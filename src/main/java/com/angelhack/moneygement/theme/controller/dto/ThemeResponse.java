package com.angelhack.moneygement.theme.controller.dto;

public record ThemeResponse(
	String themeId,
	String themeName,
	String themeDesc,
	String commodityReturn,
	String coinReturn,
	String stockReturn,
	String realEstateReturn
) {
}