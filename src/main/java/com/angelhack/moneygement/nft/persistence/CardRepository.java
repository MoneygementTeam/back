package com.angelhack.moneygement.nft.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelhack.moneygement.nft.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	List<Card> findByUserId(String userId);
}
