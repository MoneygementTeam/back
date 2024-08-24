package com.angelhack.moneygement.quiz.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quiz_history")
@IdClass(QuizHistory.class)
public class QuizHistory extends BaseEntity {

    @Id
    @Column(name = "user_id", length = 40)
    private String userId;

    @Id
    @Column(name = "quiz_id", length = 40)
    private String quizId;
}
