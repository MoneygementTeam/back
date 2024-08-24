package com.angelhack.moneygement.asset.controller;

import com.angelhack.moneygement.asset.service.AssetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/asset")
@Tag(name = "Asset Controller", description = "자산 관리를 위한 API")
public class AssetController {

    private final AssetService service;

    @GetMapping("/{userId}")
    @Operation(summary = "Get user asset amount", description = "특정 사용자의 자산 금액을 조회합니다.")
    public ResponseEntity<Object> getAsset(
            @PathVariable("userId") String userId) {
        return service.getAssetAmount(userId);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Update user asset amount", description = "특정 사용자의 자산 금액을 갱신합니다.")
    public ResponseEntity<Object> updateAssetAmount(
            @PathVariable("userId") String userId,
            @RequestBody BigDecimal amount) {
        return service.updateAssetAmount(userId, amount);
    }
}
