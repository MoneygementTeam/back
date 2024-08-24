package com.angelhack.moneygement.asset.repository;

import com.angelhack.moneygement.asset.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {

	@Query("SELECT a FROM Asset a ORDER BY a.assetAmount DESC")
	List<Asset> findAllOrderByAssetAmountDesc();

	Optional<Asset> findByUserId(String userId);

	long countByAssetAmountGreaterThan(BigDecimal assetAmount);
}
