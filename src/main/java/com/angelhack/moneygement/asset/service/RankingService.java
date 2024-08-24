package com.angelhack.moneygement.asset.service;

import static com.angelhack.moneygement.common.constant.ErrorMessage.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.angelhack.moneygement.asset.dto.RankingResponse;
import com.angelhack.moneygement.asset.entity.Asset;
import com.angelhack.moneygement.asset.repository.AssetRepository;
import com.angelhack.moneygement.character.repository.CharacterRepository;
import com.angelhack.moneygement.user.entity.User;
import com.angelhack.moneygement.user.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RankingService {
	
	private final AssetRepository assetRepository;
	
	private final UserRepository userRepository;

	private final CharacterRepository characterRepository;

	public List<RankingResponse> getTopRanking(Integer limit) {
		List<RankingResponse> rankingResponses = assetRepository.findAllOrderByAssetAmountDesc()
			.stream()
			.map(this::convertToRankingResponse)
			.collect(Collectors.toList());

		if(rankingResponses.isEmpty()) {
			return rankingResponses;
		} else {
			limit = limit <= rankingResponses.size()? limit : rankingResponses.size();
			return rankingResponses.subList(0, limit);
		}

	}

	public RankingResponse getUserRanking(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(COMMON_NOT_FOUND_WITH_TARGET.format("사용자", userId)));
		Asset asset = assetRepository.findByUserId(user.getUserId())
			.orElseThrow(() -> new EntityNotFoundException(COMMON_NOT_FOUND_WITH_TARGET.format("자산", userId)));

		long rank = assetRepository.countByAssetAmountGreaterThan(asset.getAssetAmount()) + 1;

		return convertToRankingResponse(asset, rank);
	}

	private RankingResponse convertToRankingResponse(Asset asset) {
		return convertToRankingResponse(asset, null);
	}

	private RankingResponse convertToRankingResponse(Asset asset, Long rank) {
		String userId = asset.getUserId();
		Optional<User> user = userRepository.findByUserId(userId);
		if (user.isPresent()) {
			Long currentCharacterId = user.get().getCurrentCharacterId();
			log.info(" current = {}", currentCharacterId);
			String currentMonsterImageUrl = characterRepository.findById(currentCharacterId).orElseThrow(() -> new EntityNotFoundException(COMMON_NOT_FOUND.format("캐릭터"))).getCharacterImageUrl();
			return RankingResponse.of(
					rank,
					currentMonsterImageUrl,
					asset.getAssetAmount(),
					userId
			);
		} else {
			throw new EntityNotFoundException(COMMON_NOT_FOUND.format("사용자") + userId);
		}
	}
}
