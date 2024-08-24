package com.angelhack.moneygement.monster.service;

import com.angelhack.moneygement.monster.entity.Monster;
import com.angelhack.moneygement.monster.entity.MonsterCollection;
import com.angelhack.moneygement.monster.repository.MonsterCollectionRepository;
import com.angelhack.moneygement.monster.repository.MonsterRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class MonsterService {

	private final MonsterRepository monsterRepository;
	private final MonsterCollectionRepository monsterCollectionRepository;

	public static final ConcurrentHashMap<String, Monster> monsterMap = new ConcurrentHashMap<>();

	public ResponseEntity<Object> getMonsterCollection(String userId) {
		List<MonsterCollection> monsterCollectionList = monsterCollectionRepository.findByUserId(userId);
		if (monsterCollectionList.isEmpty()) {
			return ResponseEntity.status(404).body("No monsters found for this user.");
		}
		return ResponseEntity.ok(monsterCollectionList);
	}

	public ResponseEntity<Object> getMonsterDetails(String monsterId) {
		return ResponseEntity.ok(monsterRepository.findById(monsterId).orElseThrow(() -> new RuntimeException("Monster not found")));
	}

	@PostConstruct
	public ResponseEntity<Object> getMonsters() {
		List<Monster> monsterList = monsterRepository.findAll();
		if (monsterList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		for (Monster monster : monsterList) {
			monsterMap.put(monster.getMonsterId(), monster);
		}
		return ResponseEntity.ok(monsterMap);
	}
}

