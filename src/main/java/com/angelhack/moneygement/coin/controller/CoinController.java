package com.angelhack.moneygement.coin.controller;

import com.angelhack.moneygement.coin.service.CoinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coin")
@Tag(name = "Coin Controller", description = "암호화폐 정보 API")
public class CoinController {

	private final CoinService service;

	@GetMapping("/")
	@Operation(summary = "Get coin market list", description = "암호화폐 마켓 리스트를 조회합니다.")
	public ResponseEntity<Object> getCoinList() {
		return service.getCoinList();
	}

	@GetMapping("/{userId}")
	@Operation(summary = "Get user coin list", description = "특정 유저의 보유코인 리스트를 조회합니다.")
	public ResponseEntity<Object> getUserCoinList(
		@PathVariable("userId") String userId) {
		return service.getUserCoinList(userId);
	}
}
