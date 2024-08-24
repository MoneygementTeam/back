package com.angelhack.moneygement.theme.service;

import com.angelhack.moneygement.theme.entity.Theme;
import com.angelhack.moneygement.theme.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeService {

	private final ThemeRepository themeRepository;

	public ResponseEntity<Object> getThemeList() {
		List<Theme> themes = themeRepository.findAll();
		if (!themes.isEmpty()) {
			return ResponseEntity.ok(themes);
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
