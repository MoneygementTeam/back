package com.angelhack.moneygement.nft.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angelhack.moneygement.nft.controller.dto.CardCreateRequest;
import com.angelhack.moneygement.nft.domain.Card;
import com.angelhack.moneygement.nft.service.CardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
	private final CardService cardService;

	@PostMapping
	public ResponseEntity<Card> createCard(@RequestBody @Valid CardCreateRequest request) {
		Card createdCard = cardService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
	}

	@GetMapping
	public ResponseEntity<List<Card>> getCardsByUserId(@RequestParam String userId) {
		List<Card> cards = cardService.findAll(userId);
		return ResponseEntity.ok(cards);
	}
}
