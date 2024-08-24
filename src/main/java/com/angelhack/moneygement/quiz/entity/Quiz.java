package com.angelhack.moneygement.quiz.quiz.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "quiz")
public class Quiz extends BaseEntity {

    @Id
    @Column(name = "quiz_id", length = 40)
    private String quizId;

    @Column(name = "theme_id", length = 40)
    private String themeId;

    @Column(name = "ai_prompt_id", length = 40)
    private String aiPromptId;

    @Column(name = "priority")
    private Integer priority;
}
