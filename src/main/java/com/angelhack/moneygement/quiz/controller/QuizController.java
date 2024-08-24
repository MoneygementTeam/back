package com.angelhack.moneygement.quiz.controller;

import com.angelhack.moneygement.ai.dto.InvestDecision;
import com.angelhack.moneygement.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz")
@Tag(name = "Quiz Controller", description = "퀴즈 관리를 위한 API")
public class QuizController {

    private final QuizService service;

    @GetMapping("/{themeId}/{userId}")
    @Operation(summary = "Get a quiz for the user", description = "특정 사용자를 위한 퀴즈를 조회합니다.")
    public ResponseEntity<Object> getQuiz(
            @PathVariable("themeId") String themeId,
            @PathVariable("userId") String userId) {
        return service.getQuiz(themeId, userId);
    }

    @PostMapping("/{userId}/{quizId}")
    @Operation(summary = "Submit a quiz answer", description = "사용자가 퀴즈의 답을 제출합니다.")
    public ResponseEntity<Object> submitQuizAnswer(
            @PathVariable("userId") String userId,
            @PathVariable("quizId") String quizId,
            @RequestBody InvestDecision investDecision) {
        return service.submitQuizAnswer(userId, quizId, investDecision);
    }
}
