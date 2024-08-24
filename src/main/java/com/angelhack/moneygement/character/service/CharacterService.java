package com.angelhack.moneygement.character.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.angelhack.moneygement.character.entity.Character;
import com.angelhack.moneygement.character.entity.CharacterCollection;
import com.angelhack.moneygement.character.repository.CharacterCollectionRepository;
import com.angelhack.moneygement.character.repository.CharacterRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterService {

	private final CharacterRepository characterRepository;
	private final CharacterCollectionRepository characterCollectionRepository;


	public ResponseEntity<Object> getCharacterCollection(String userId) {
		List<CharacterCollection> monsterCollectionList = characterCollectionRepository.findByUserId(userId);
		if (monsterCollectionList.isEmpty()) {
			return ResponseEntity.status(404).body("유저가 보유중인 캐릭터가 없습니다.");
		}
		return ResponseEntity.ok(monsterCollectionList);
	}

	public ResponseEntity<Character> getCharacterDetails(Long characterId) {
		return ResponseEntity.ok(characterRepository.findById(characterId).orElseThrow(() -> new EntityNotFoundException("해당 캐릭터를 찾을 수 없습니다.")));
	}

}
