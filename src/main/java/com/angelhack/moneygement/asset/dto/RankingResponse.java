package com.angelhack.moneygement.asset.dto;

import java.math.BigDecimal;

public record RankingResponse (Long rank,
							   String monsterImageUrl,
							   BigDecimal assetAmount,
							   String userId){

	public static RankingResponse of(Long rank,
		String monsterImageUrl,
		BigDecimal assetAmount,
		String userId) {

		return new RankingResponse(rank, monsterImageUrl, assetAmount, userId);

	}
}
