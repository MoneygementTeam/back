package com.angelhack.moneygement.nft.domain;

import com.angelhack.moneygement.common.audit.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "NFT_CARD")
@Getter
@Setter
public class Card extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USER_ID", nullable = false)
	private String userId;

	@Column(name = "NFT_ID", nullable = false)
	private String nftId;

	@Column(name = "CARD_URL", length = 2083, nullable = false)
	private String cardUrl;

	public static Card create(String userId, String nftId, String cardUrl) {
		Card card = new Card();
		card.setUserId(userId);
		card.setNftId(nftId);
		card.setCardUrl(cardUrl);

		return card;
	}
}
