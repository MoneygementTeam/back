package com.angelhack.moneygement.coin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CoinDto {
	private String market;
	@JsonProperty("korean_name")
	private String koreanName;
	@JsonProperty("english_name")
	private String englishName;
}
