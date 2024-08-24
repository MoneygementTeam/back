package com.angelhack.moneygement.coin.service;

import static com.angelhack.moneygement.common.util.HttpClientUtil.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.angelhack.moneygement.coin.dto.CoinDto;
import com.angelhack.moneygement.coin.entity.Coin;
import com.angelhack.moneygement.coin.repository.CoinRepository;
import com.angelhack.moneygement.common.config.UrlConfig;
import com.angelhack.moneygement.common.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoinService {

	private final UrlConfig urlConfig;
	private final CoinRepository repository;
	private static List<CoinDto> coinList;
	private static ConcurrentHashMap<String, CoinDto> coinMarketMap = new ConcurrentHashMap<>();

	@PostConstruct
	public ResponseEntity<Object> getCoinList() {
		if (coinMarketMap == null || coinMarketMap.isEmpty()) {
			ResponseEntity<Object> response = get(null, urlConfig.getGetCoinMarketUrl());
			try {
				String responseBody = JsonUtil.objectMapper.writeValueAsString(response.getBody());
				coinList = JsonUtil.objectMapper.readValue(responseBody, new TypeReference<>() {
				});
			} catch (JsonProcessingException e) {
				log.error("Failed to parse JSON of coin market list", e);
			}
			setCoinMarketMap(coinList);
			log.info("Coin market list loaded successfully loaded. {}", coinList);
		}
		return ResponseEntity.ok().body(coinList);
	}

	public ResponseEntity<Object> getUserCoinList(String userId) {
		List<Coin> userCoinList = repository.findByUserId(userId);
		return ResponseEntity.ok().body(userCoinList);
	}

	private void setCoinMarketMap(List<CoinDto> coinList) {
		if (coinList != null && !coinList.isEmpty()) {
			for (CoinDto coinDto : coinList) {
				coinMarketMap.put(coinDto.getMarket(), coinDto);
			}
		}
	}
}
