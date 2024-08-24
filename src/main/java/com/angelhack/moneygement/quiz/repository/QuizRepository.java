package com.angelhack.moneygement.quiz.repository;

import com.angelhack.moneygement.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {
    List<Quiz> findByThemeId(String themeId);
}
