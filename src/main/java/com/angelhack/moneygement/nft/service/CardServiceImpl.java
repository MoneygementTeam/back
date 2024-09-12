package com.angelhack.moneygement.nft.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angelhack.moneygement.nft.controller.dto.CardCreateRequest;
import com.angelhack.moneygement.nft.domain.Card;
import com.angelhack.moneygement.nft.persistence.CardRepository;
import com.angelhack.moneygement.nft.service.mapper.CardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
	private final CardRepository cardRepository;
	private final CardMapper cardMapper;

	@Override
	@Transactional
	public Card save(CardCreateRequest cardCreateRequest) {
		return cardRepository.save(cardMapper.toEntity(cardCreateRequest));
	}

	@Override
 	@Transactional(readOnly = true)
	public List<Card> findAll(String userId) {
		return cardRepository.findByUserId(userId);
	}
}
