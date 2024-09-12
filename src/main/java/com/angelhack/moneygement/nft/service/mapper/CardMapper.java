package com.angelhack.moneygement.nft.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.angelhack.moneygement.nft.controller.dto.CardCreateRequest;
import com.angelhack.moneygement.nft.domain.Card;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {

	Card toEntity(CardCreateRequest request);
}