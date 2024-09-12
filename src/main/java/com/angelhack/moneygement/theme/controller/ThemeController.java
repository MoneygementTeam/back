package com.angelhack.moneygement.theme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelhack.moneygement.theme.service.ThemeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/theme")
@Tag(name = "Theme Controller", description = "테마 목록 관리를 위한 API")
public class ThemeController {

	private final ThemeService themeService;

	@GetMapping("/")
	@Operation(summary = "Get list of all themes", description = "모든 테마의 목록을 가져옵니다.")
	public ResponseEntity<Object> getThemeList() {
		return themeService.getThemeList();
	}

	@GetMapping("/{page}/{size}")
	@Operation(summary = "Get paginated list of themes", description = "페이징 처리된 테마 목록을 가져옵니다.")
	public ResponseEntity<Object> getThemeListPaginated(
		@PathVariable("page") int page,
		@PathVariable("size") int size) {
		return themeService.getThemeListPaginated(page, size);
	}
}