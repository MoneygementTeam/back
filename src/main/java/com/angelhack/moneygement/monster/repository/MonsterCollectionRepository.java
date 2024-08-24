package com.angelhack.moneygement.monster.repository;

import com.angelhack.moneygement.monster.entity.MonsterCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterCollectionRepository extends JpaRepository<MonsterCollection, String> {
    List<MonsterCollection> findByUserId(String userId);
}
