package com.angelhack.moneygement.nft.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CardCreateRequest(@NotNull String userId, @NotNull String nftId, @NotNull String cardUrl) {
}
