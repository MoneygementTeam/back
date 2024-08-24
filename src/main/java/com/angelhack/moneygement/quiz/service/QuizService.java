package com.angelhack.moneygement.quiz.service;

import com.angelhack.moneygement.ai.dto.InvestDecision;
import com.angelhack.moneygement.ai.entity.AiPrompt;
import com.angelhack.moneygement.asset.entity.Asset;
import com.angelhack.moneygement.common.constant.InvestRatioCategory;
import com.angelhack.moneygement.ai.repository.AiPromptRepository;
import com.angelhack.moneygement.asset.repository.AssetRepository;
import com.angelhack.moneygement.quiz.entity.Quiz;
import com.angelhack.moneygement.quiz.entity.QuizHistory;
import com.angelhack.moneygement.quiz.repository.QuizHistoryRepository;
import com.angelhack.moneygement.quiz.repository.QuizRepository;
import com.angelhack.moneygement.user.entity.User;
import com.angelhack.moneygement.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizService {

	private final QuizRepository quizRepository;
	private final QuizHistoryRepository quizHistoryRepository;
	private final AssetRepository assetRepository;
	private final UserRepository userRepository;
	private final AiPromptRepository aiPromptRepository;

	public ResponseEntity<Object> getQuiz(String themeId, String userId) {
		List<Quiz> allQuizzesForTheme = quizRepository.findByThemeId(themeId);

		List<String> completedQuizIds = quizHistoryRepository.findByUserId(userId)
			.stream()
			.map(QuizHistory::getQuizId)
			.collect(Collectors.toList());

		List<Quiz> availableQuizzes = allQuizzesForTheme.stream()
			.filter(quiz -> !completedQuizIds.contains(quiz.getQuizId()))
			.collect(Collectors.toList());

		Quiz selectedQuiz;
		if (!availableQuizzes.isEmpty()) {
			Random random = new Random();
			selectedQuiz = availableQuizzes.get(random.nextInt(availableQuizzes.size()));
		} else {
			Random random = new Random();
			selectedQuiz = allQuizzesForTheme.get(random.nextInt(allQuizzesForTheme.size()));
		}
		return ResponseEntity.ok(selectedQuiz);
	}

	// TODO 복잡도 개선 필요
	public ResponseEntity<Object> submitQuizAnswer(String userId, String quizId, InvestDecision investDecision) {
		// 퀴즈 가져오기
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new EntityNotFoundException("퀴즈를 찾을 수 없습니다."));

		// 유저 가져오기
		User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));

		// QuizHistory에 이미 동일한 퀴즈 기록이 있는지 확인
		boolean exists = quizHistoryRepository.existsByUserIdAndQuizId(userId, quizId);
		if (!exists) {
			// QuizHistory에 퀴즈 추가 (중복이 아닌 경우)
			QuizHistory quizHistory = new QuizHistory();
			quizHistory.setUserId(userId);
			quizHistory.setQuizId(quizId);
			quizHistoryRepository.save(quizHistory);
		}

		// 자산 가져오기
		Asset asset = assetRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("자산 정보를 찾을 수 없습니다."));

		// 퀴즈의 Answer에서 fluctuationRate 추출
		AiPrompt aiPrompt = aiPromptRepository.findById(quiz.getAiPromptId()).orElseThrow(() -> new EntityNotFoundException("AI Prompt 정보를 찾을 수 없습니다."));
		String aiAnswerJson = aiPrompt.getAiAnswer();
		JSONObject aiAnswer = new JSONObject(aiAnswerJson);
		JSONObject subInvestCategories = aiAnswer.getJSONObject("subInvestCategory");

		// subInvestCategory와 fluctuationRate 매핑
		String selectedCategory = investDecision.subInvestCategory();
		BigDecimal fluctuationRate = null;
		String description = null;

		// subInvestCategories에서 선택된 카테고리를 탐색
		for (String key : subInvestCategories.keySet()) {
			JSONArray categoryArray = subInvestCategories.getJSONArray(key);
			for (int i = 0; i < categoryArray.length(); i++) {
				JSONObject categoryObject = categoryArray.getJSONObject(i);
				if (categoryObject.has(selectedCategory)) {
					fluctuationRate = categoryObject.getJSONObject(selectedCategory).getBigDecimal("fluctuationRate");
					description = categoryObject.getJSONObject(selectedCategory).getString("description");
					break;
				}
			}
			if (fluctuationRate != null) {
				break;
			}
		}

		if (fluctuationRate == null) {
			return ResponseEntity.badRequest().body("유효하지 않은 소분류 투자 카테고리가 선택되었습니다.");
		}

		// 투자 비율 계산
		BigDecimal investRatio = investDecision.investRatio();
		BigDecimal investAmount = asset.getAssetAmount().multiply(investRatio);

		// 자산 업데이트 (투자 금액에 등락률 적용)
		BigDecimal updatedAssetAmount = asset.getAssetAmount().subtract(investAmount)
			.add(investAmount.multiply(fluctuationRate));
		asset.setAssetAmount(updatedAssetAmount);
		assetRepository.save(asset);

		// 투자 결과에 대한 피드백 생성
		String feedback = getInvestFeedback(aiPrompt, asset, investDecision);

		// 피드백을 응답으로 반환
		return ResponseEntity.ok(feedback);
	}

	private String getInvestFeedback(AiPrompt aiPrompt, Asset asset, InvestDecision investDecision) {
		// 투자 비율과 자산 변동에 따라 적절한 피드백을 제공하는 AI Prompt 가져오기
		BigDecimal investRatio = investDecision.investRatio();
		BigDecimal updatedAssetAmount = asset.getAssetAmount();

		// Enum을 사용하여 적절한 카테고리 결정
		InvestRatioCategory category = InvestRatioCategory.fromInvestRatio(investRatio, updatedAssetAmount);
		String aiPromptId = category.getAiPromptId();

		// AI Prompt 가져오기
		AiPrompt selectedAiPrompt = aiPromptRepository.findById(aiPromptId)
			.orElseThrow(() -> new RuntimeException("AI Prompt not found"));

		// AI Prompt의 답변에서 피드백 정보를 가져오기
		String aiAnswerJson = selectedAiPrompt.getAiAnswer();
		JSONObject aiAnswer = new JSONObject(aiAnswerJson);

		String assetFeedback = aiAnswer.getString("assetFeedback");
		String investFeedback = aiAnswer.getString("investFeedback");

		// 피드백 메시지를 JSON 형식으로 생성
		String feedback = String.format("{\"assetFeedback\": \"%s\", \"investFeedback\": \"%s\"}", assetFeedback, investFeedback);

		return feedback;
	}
}
