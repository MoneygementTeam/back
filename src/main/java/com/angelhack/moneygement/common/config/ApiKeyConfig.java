package com.angelhack.moneygement.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
@Deprecated
public class ApiKeyConfig {
    @Value("${spring.ai.openai.api-key}")
    private String openAiApiKey;
}
