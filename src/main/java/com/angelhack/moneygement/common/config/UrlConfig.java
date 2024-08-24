package com.angelhack.moneygement.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UrlConfig {
    @Value("${url.open-ai}")
    private String openAiUrl;

    @Value("${url.upbeat.get-market}")
    private String getCoinMarketUrl;
}
