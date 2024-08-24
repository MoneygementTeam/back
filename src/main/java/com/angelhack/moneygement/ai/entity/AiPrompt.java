package com.angelhack.moneygement.ai.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ai_prompt")
public class AiPrompt extends BaseEntity {

    @Id
    @Column(name = "ai_prompt_id", length = 40)
    private String aiPromptId;

    @Column(name = "ai_prompt_class", length = 20)
    private String aiPromptClass;

    @Column(name = "ai_question", length = 2000)
    private String aiQuestion;

    @Column(name = "ai_answer", length = 2000)
    private String aiAnswer;
}
