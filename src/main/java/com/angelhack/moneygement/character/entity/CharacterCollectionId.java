package com.angelhack.moneygement.character.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterCollectionId implements Serializable {
	private String userId;
	private Long characterId;
}
