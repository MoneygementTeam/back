package com.angelhack.moneygement.common.constant;

import java.math.BigDecimal;

public enum InvestRatioCategory {
    INVEST_HEAVILY("INVEST_HEAVILY", new BigDecimal("0.80"), null),
    INVEST_A_LOT("INVEST_A_LOT", new BigDecimal("0.50"), new BigDecimal("0.80")),
    INVEST_MODERATELY("INVEST_MODERATELY", new BigDecimal("0.30"), new BigDecimal("0.50")),
    INVEST_LESS("INVEST_LESS", new BigDecimal("0.10"), new BigDecimal("0.30")),
    INVEST_TOO_LITTLE("INVEST_TOO_LITTLE", new BigDecimal("0.00"), new BigDecimal("0.10")),
    BELOW_ZERO_FUNDS("BELOW_ZERO_FUNDS", null, null);  // 자산이 음수일 때 사용

    private final String aiPromptId;
    private final BigDecimal minRatio;
    private final BigDecimal maxRatio;

    InvestRatioCategory(String aiPromptId, BigDecimal minRatio, BigDecimal maxRatio) {
        this.aiPromptId = aiPromptId;
        this.minRatio = minRatio;
        this.maxRatio = maxRatio;
    }

    public String getAiPromptId() {
        return aiPromptId;
    }

    public static InvestRatioCategory fromInvestRatio(BigDecimal investRatio, BigDecimal updatedAssetAmount) {
        if (updatedAssetAmount.compareTo(BigDecimal.ZERO) < 0) {
            return BELOW_ZERO_FUNDS;  // 자산이 음수일 경우
        }

        for (InvestRatioCategory category : values()) {
            if (category.minRatio != null && category.maxRatio != null
                    && investRatio.compareTo(category.minRatio) >= 0
                    && investRatio.compareTo(category.maxRatio) < 0) {
                return category;
            }
        }

        throw new IllegalArgumentException("Invalid invest ratio");
    }
}
