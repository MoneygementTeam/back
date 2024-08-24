package com.angelhack.moneygement.ai.dto;

import java.math.BigDecimal;

public record InvestDecision (
	String subInvestCategory, // 사용자가 선택한 소분류 투자 카테고리
	BigDecimal investRatio   // 투자 비율 (0.0 ~ 1.0)
) {}
