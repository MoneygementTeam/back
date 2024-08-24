package com.angelhack.moneygement.character.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelhack.moneygement.character.entity.CharacterCollection;
import com.angelhack.moneygement.character.entity.CharacterCollectionId;

@Repository
public interface CharacterCollectionRepository extends JpaRepository<CharacterCollection, CharacterCollectionId> {
	List<CharacterCollection> findByUserId(String userId);
}
