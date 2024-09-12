package com.angelhack.moneygement.theme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.angelhack.moneygement.theme.controller.dto.ThemeResponse;
import com.angelhack.moneygement.theme.domain.Theme;
import com.angelhack.moneygement.theme.domain.ThemeInvestReturn;
import com.angelhack.moneygement.theme.persistence.ThemeInvestReturnRepository;
import com.angelhack.moneygement.theme.persistence.ThemeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThemeService {

	private final ThemeRepository themeRepository;
	private final ThemeInvestReturnRepository themeInvestReturnRepository;

	public ResponseEntity<Object> getThemeList() {
		List<Theme> themes = themeRepository.findAll();

		if (!themes.isEmpty()) {
			List<ThemeResponse> themeDTOs = themes.stream().map(theme -> {
				ThemeInvestReturn investReturn = themeInvestReturnRepository.findById(theme.getThemeId()).orElse(null);

				return new ThemeResponse(
					theme.getThemeId(),
					theme.getThemeName(),
					theme.getThemeDesc(),
					investReturn != null ? investReturn.getCommodityReturn() : null,
					investReturn != null ? investReturn.getCoinReturn() : null,
					investReturn != null ? investReturn.getStockReturn() : null,
					investReturn != null ? investReturn.getRealEstateReturn() : null
				);
			}).collect(Collectors.toList());

			return ResponseEntity.ok(themeDTOs);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	public ResponseEntity<Object> getThemeListPaginated(int page, int size) {
		Page<Theme> themePage = themeRepository.findAll(PageRequest.of(page, size));
		if (themePage.hasContent()) {
			return ResponseEntity.ok(themePage.getContent());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}