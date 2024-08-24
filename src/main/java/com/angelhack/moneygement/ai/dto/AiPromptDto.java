package com.angelhack.moneygement.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AiPromptDto {
    private String aiQuestion;
    private InvestCaterogy aiAnswer;
}
