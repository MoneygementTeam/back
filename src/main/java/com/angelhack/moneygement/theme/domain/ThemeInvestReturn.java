package com.angelhack.moneygement.theme.domain;

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
@Table(name = "theme_invest_return")
public class ThemeInvestReturn {

	@Id
	private String themeId;

	@Column(name = "commodity_return", length = 10)
	private String commodityReturn;

	@Column(name = "coin_return", length = 10)
	private String coinReturn;

	@Column(name = "stock_return", length = 10)
	private String stockReturn;

	@Column(name = "real_estate_return", length = 10)
	private String realEstateReturn;

}