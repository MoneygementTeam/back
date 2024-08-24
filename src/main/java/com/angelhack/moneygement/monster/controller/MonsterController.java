package com.angelhack.moneygement.monster.controller;

import com.angelhack.moneygement.monster.service.MonsterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/monster")
@Tag(name = "몬스터 컬렉션 API", description = "사용자의 몬스터 컬렉션 및 몬스터 상세 정보를 관리하는 API")
public class MonsterController {

    private final MonsterService monsterService;

    @Operation(summary = "Get Monster Collection by User ID", description = "특정 사용자 ID에 해당하는 몬스터 컬렉션 목록을 조회합니다.")
    @GetMapping("/collection/{userId}")
    public ResponseEntity<Object> getMonsterCollection(
            @PathVariable("userId") String userId) {
        return monsterService.getMonsterCollection(userId);
    }

    @Operation(summary = "Get Monster Details", description = "특정 몬스터 ID에 해당하는 몬스터의 상세 정보를 조회합니다.")
    @GetMapping("/{monsterId}")
    public ResponseEntity<Object> getMonsterDetails(
            @PathVariable("monsterId") String monsterId) {
        return monsterService.getMonsterDetails(monsterId);
    }
}
