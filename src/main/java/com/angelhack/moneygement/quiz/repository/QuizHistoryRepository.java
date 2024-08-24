package com.angelhack.moneygement.quiz.repository;

import com.angelhack.moneygement.quiz.entity.QuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizHistoryRepository extends JpaRepository<QuizHistory, String> {
    List<QuizHistory> findByUserId(String userId);
    boolean existsByUserIdAndQuizId(String userId, String quizId);
}
