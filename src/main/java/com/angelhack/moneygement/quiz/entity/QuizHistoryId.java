package com.angelhack.moneygement.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizHistoryId implements Serializable {
    private String userId;
    private String quizId;
}
