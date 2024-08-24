package com.angelhack.moneygement.character.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelhack.moneygement.character.entity.Character;
import com.angelhack.moneygement.character.service.CharacterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/character")
@Tag(name = "캐릭터 API", description = "사용자의 캐릭터 컬렉션 및 캐릭터 상세 정보를 관리하는 API")
public class CharacterController {

	private final CharacterService characterService;

	@Operation(summary = "Get Character Collection by User ID", description = "특정 사용자 ID에 해당하는 캐릭터 컬렉션 목록을 조회합니다.")
	@GetMapping("/collection/{userId}")
	public ResponseEntity<?> getCharacterCollection(
		@PathVariable("userId") String userId) {
		return characterService.getCharacterCollection(userId);
	}

	@Operation(summary = "Get Character Details", description = "특정 캐릭터 ID에 해당하는 캐릭터의 상세 정보를 조회합니다.")
	@GetMapping("/{characterId}")
	public ResponseEntity<?> getCharacterDetails(
		@PathVariable("characterId") Long id) {
		return characterService.getCharacterDetails(id);
	}
}
