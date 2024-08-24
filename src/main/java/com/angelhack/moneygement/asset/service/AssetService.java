package com.angelhack.moneygement.asset.service;

import static com.angelhack.moneygement.common.constant.ErrorMessage.*;

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
	private static final BigDecimal INITIAL_AMOUNT = BigDecimal.valueOf(100000);

	public ResponseEntity<Object> getAssetAmount(String userId) {
		Optional<Asset> assetEntityOptional = assetRepository.findById(userId);
		if (assetEntityOptional.isPresent()) {
			BigDecimal assetAmount = assetEntityOptional.get().getAssetAmount();
			return ResponseEntity.ok(assetAmount);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(COMMON_NOT_FOUND_WITH_TARGET.format("자산", userId));
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
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(COMMON_NOT_FOUND_WITH_TARGET.format("자산", userId));
		}
	}

	public ResponseEntity<Object> addAssetAmount(String userId, BigDecimal amountToAdd) {
		Optional<Asset> assetEntityOptional = assetRepository.findById(userId);
		if (assetEntityOptional.isPresent()) {
			Asset asset = assetEntityOptional.get();
			BigDecimal updatedAmount = asset.getAssetAmount().add(amountToAdd);
			asset.setAssetAmount(updatedAmount);
			assetRepository.save(asset);
			return ResponseEntity.ok("Asset amount added successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(COMMON_NOT_FOUND_WITH_TARGET.format("자산", userId));
		}
	}

	public ResponseEntity<Object> createAsset(String userId) {
		// 사용자가 이미 자산을 가지고 있는지 확인
		Optional<Asset> existingAsset = assetRepository.findById(userId);
		if (existingAsset.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Asset already exists for this user");
		}

		// 새로운 자산 생성
		Asset newAsset = new Asset();
		newAsset.setUserId(userId);
		newAsset.setAssetAmount(INITIAL_AMOUNT);

		// 자산 저장
		assetRepository.save(newAsset);

		return ResponseEntity.status(HttpStatus.CREATED).body("Asset created successfully");
	}
}
