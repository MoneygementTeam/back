package com.angelhack.moneygement.asset.controller;

import com.angelhack.moneygement.asset.dto.RankingResponse;
import com.angelhack.moneygement.asset.service.RankingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/asset/ranking")
@Tag(name = "Ranking Controller", description = "자산 순위 API")
public class RankingController {

	private final RankingService rankingService;

	@GetMapping("/top")
	@Operation(summary = "Get user asset ranking list ", description = "사용자의 자산 순위를 조회합니다.")
	public ResponseEntity<List<RankingResponse>> getTopRanking(@RequestParam(required = false, defaultValue = "10") Integer limit) {
		List<RankingResponse> topRanking = rankingService.getTopRanking(limit);
		return ResponseEntity.ok(topRanking);
	}

	@GetMapping("/{userId}")
	@Operation(summary = "Get user asset amount ranking", description = "특정 사용자의 자산 순위를 조회합니다.")
	public ResponseEntity<RankingResponse> getUserRanking(@PathVariable String userId) {
		RankingResponse userRanking = rankingService.getUserRanking(userId);
		return ResponseEntity.ok(userRanking);
	}
}
