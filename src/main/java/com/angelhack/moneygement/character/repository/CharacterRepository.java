package com.angelhack.moneygement.character.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelhack.moneygement.character.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
