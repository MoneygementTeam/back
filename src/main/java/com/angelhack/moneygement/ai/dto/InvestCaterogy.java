package com.angelhack.moneygement.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class InvestCaterogy {
    private final List<String> majorInvestCategory;
    private final Map<String, List<SubInvestCategory>> subInvestCategories;

    @Data
    public static class SubInvestCategory {
        private final String name;
        private final BigDecimal fluctuationRate;
        private final String description;

        public SubInvestCategory(String name, BigDecimal fluctuationRate, String description) {
            this.name = name;
            this.fluctuationRate = fluctuationRate;
            this.description = description;
        }
    }
}
