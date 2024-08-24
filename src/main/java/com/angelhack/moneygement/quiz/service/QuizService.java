package com.angelhack.moneygement.quiz.service;

import com.angelhack.moneygement.ai.dto.AiFeedback;
import com.angelhack.moneygement.ai.dto.AiPromptDto;
import com.angelhack.moneygement.ai.dto.InvestCaterogy;
import com.angelhack.moneygement.ai.dto.InvestCaterogy.SubInvestCategory;
import com.angelhack.moneygement.ai.dto.InvestDecision;
import com.angelhack.moneygement.ai.entity.AiPrompt;
import com.angelhack.moneygement.asset.entity.Asset;
import com.angelhack.moneygement.asset.service.AssetService;
import com.angelhack.moneygement.common.constant.InvestRatioCategory;
import com.angelhack.moneygement.ai.repository.AiPromptRepository;
import com.angelhack.moneygement.asset.repository.AssetRepository;
import com.angelhack.moneygement.quiz.converter.InvestCaterogyConverter;
import com.angelhack.moneygement.quiz.entity.Quiz;
import com.angelhack.moneygement.quiz.entity.QuizHistory;
import com.angelhack.moneygement.quiz.repository.QuizHistoryRepository;
import com.angelhack.moneygement.quiz.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizService {

	private final QuizRepository quizRepository;
	private final QuizHistoryRepository quizHistoryRepository;
	private final AssetRepository assetRepository;
	private final AiPromptRepository aiPromptRepository;
	private final AssetService assetService;

	public ResponseEntity<Object> getQuiz(String themeId, String userId) {
		// 해당 테마의 모든 퀴즈 가져오기
		List<Quiz> allQuizzesForTheme = quizRepository.findByThemeId(themeId);

		// 유저가 이미 푼 퀴즈를 제외
		List<String> completedQuizIds = quizHistoryRepository.findByUserId(userId)
			.stream()
			.map(QuizHistory::getQuizId)
			.collect(Collectors.toList());
		List<Quiz> availableQuizzes = allQuizzesForTheme.stream()
			.filter(quiz -> !completedQuizIds.contains(quiz.getQuizId()))
			.collect(Collectors.toList());

		// 남은  퀴즈 중 랜덤으로 선정
		Quiz selectedQuiz;
		if (!availableQuizzes.isEmpty()) {
			Random random = new Random();
			selectedQuiz = availableQuizzes.get(random.nextInt(availableQuizzes.size()));
		} else {
			Random random = new Random();
			selectedQuiz = allQuizzesForTheme.get(random.nextInt(allQuizzesForTheme.size()));
		}

		// 선택된 퀴즈의 AiPrompt 정보 가져오기
		AiPrompt aiPrompt = aiPromptRepository.findById(selectedQuiz.getAiPromptId())
				.orElseThrow(() -> new EntityNotFoundException("AI Prompt 정보를 찾을 수 없습니다."));

		// DTO로 변환
		AiPromptDto aiPromptDto = new AiPromptDto(aiPrompt.getAiQuestion(), InvestCaterogyConverter.fromJson(aiPrompt.getAiAnswer()));

		return ResponseEntity.ok(aiPromptDto);
	}

	public ResponseEntity<Object> submitQuizAnswer(String userId, String quizId, InvestDecision investDecision) {
		// QuizHistory에 동일한 퀴즈 기록이 없으면 추가
		addQuizHistoryIfDoesNotExist(userId, quizId);

		// 퀴즈의 Answer에서 fluctuationRate 추출
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new EntityNotFoundException("퀴즈를 찾을 수 없습니다."));
		AiPrompt aiPrompt = aiPromptRepository.findById(quiz.getAiPromptId()).orElseThrow(() -> new EntityNotFoundException("AI Prompt 정보를 찾을 수 없습니다."));
		String selectedCategory = investDecision.subInvestCategory();
		InvestCaterogy investCaterogy = InvestCaterogyConverter.fromJson(aiPrompt.getAiAnswer());
		BigDecimal fluctuationRate = getFluctuationRate(selectedCategory, investCaterogy);

		// 자산 업데이트 (투자 금액에 등락률 적용)
		Asset asset = assetRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("자산 정보를 찾을 수 없습니다."));
		BigDecimal investAmount = asset.getAssetAmount().multiply(investDecision.investRatio());
		BigDecimal amountToAdd = investAmount.multiply(fluctuationRate).subtract(investAmount);
		assetService.addAssetAmount(userId, amountToAdd);

		// 투자 결과에 대한 피드백 생성
		AiFeedback aiFeedback = getInvestFeedback(asset, investDecision);

		// 피드백을 응답으로 반환
		return ResponseEntity.ok(aiFeedback);
	}

	private AiFeedback getInvestFeedback(Asset asset, InvestDecision investDecision) {
		// 투자 비율과 자산 변동 가져오기
		BigDecimal investRatio = investDecision.investRatio();
		BigDecimal updatedAssetAmount = asset.getAssetAmount();

		// 투자 비율에 따라 투자 비율 카테고리 결정
		InvestRatioCategory investRatioCategory = InvestRatioCategory.fromInvestRatio(investRatio, updatedAssetAmount);

		// 투자 비율 카테고리에 해당하는 AI Feedback Prompt 가져오기
		AiPrompt selectedAiPrompt = aiPromptRepository.findById(investRatioCategory.getAiPromptId())
			.orElseThrow(() -> new RuntimeException("AI Prompt not found"));

		// AI Prompt의 답변에서 피드백 정보를 가져오기
		JSONObject aiAnswer = new JSONObject(selectedAiPrompt.getAiAnswer());

		// AI 피드백 메시지 생성
		String assetFeedback = aiAnswer.getString("assetFeedback");
		String investFeedback = aiAnswer.getString("investFeedback");
		AiFeedback aiFeedback = new AiFeedback(assetFeedback, investFeedback);

		return aiFeedback;
	}

	public void addQuizHistoryIfDoesNotExist(String userId, String quizId) {
		// QuizHistory에 이미 동일한 퀴즈 기록이 있는지 확인
		boolean exists = quizHistoryRepository.existsByUserIdAndQuizId(userId, quizId);
		if (!exists) {
			// QuizHistory에 퀴즈 추가 (중복이 아닌 경우)
			QuizHistory quizHistory = new QuizHistory();
			quizHistory.setUserId(userId);
			quizHistory.setQuizId(quizId);
			quizHistoryRepository.save(quizHistory);
		}
	}

	public BigDecimal getFluctuationRate(String selectedCategory, InvestCaterogy investCaterogy) {
		for (Map.Entry<String, List<SubInvestCategory>> entry : investCaterogy.getSubInvestCategories().entrySet()) {
			for (SubInvestCategory subCategory : entry.getValue()) {
				if (subCategory.getName().equals(selectedCategory)) {
					return subCategory.getFluctuationRate();
				}
			}
		}
		return BigDecimal.ZERO;
	}
}
