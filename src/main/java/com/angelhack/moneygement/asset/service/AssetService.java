package com.angelhack.moneygement.asset.service;

import com.angelhack.moneygement.asset.entity.Asset;
import com.angelhack.moneygement.asset.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetService {

	private final AssetRepository assetRepository;

	public ResponseEntity<Object> getAssetAmount(String userId) {
		Optional<Asset> assetEntityOptional = assetRepository.findById(userId);
		if (assetEntityOptional.isPresent()) {
			BigDecimal assetAmount = assetEntityOptional.get().getAssetAmount();
			return ResponseEntity.ok(assetAmount);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	public ResponseEntity<Object> updateAssetAmount(String userId, BigDecimal amount) {
		Optional<Asset> assetEntityOptional = assetRepository.findById(userId);
		if (assetEntityOptional.isPresent()) {
			Asset asset = assetEntityOptional.get();
			asset.setAssetAmount(amount);
			assetRepository.save(asset);
			return ResponseEntity.ok("Asset amount updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}
}
