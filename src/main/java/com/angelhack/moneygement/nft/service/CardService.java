package com.angelhack.moneygement.nft.service;

import java.util.List;

import com.angelhack.moneygement.nft.controller.dto.CardCreateRequest;
import com.angelhack.moneygement.nft.domain.Card;

public interface CardService {

	Card save(CardCreateRequest cardCreateRequest);

	List<Card> findAll(String userId);
}
