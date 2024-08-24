package com.angelhack.moneygement.coin.repository;

import com.angelhack.moneygement.coin.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoinRepository extends JpaRepository<Coin, Long> {
    List<Coin> findByUserId(String userId);
}
