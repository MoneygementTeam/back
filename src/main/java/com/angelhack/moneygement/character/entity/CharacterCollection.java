package com.angelhack.moneygement.character.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "character_collection")
@IdClass(CharacterCollectionId.class)
public class CharacterCollection extends BaseEntity {

	@Id
	@Column(name = "user_id", length = 40)
	private String userId;

	@Id
	@Column(name = "character_id")
	private Long characterId;
}

