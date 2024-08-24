package com.angelhack.moneygement.character.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "`character`")
public class Character extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "character_id")
	private Long characterId;

	@Column(name = "character_name", length = 40)
	private String characterName;

	@Column(name = "character_image_url", length = 2083)
	private String characterImageUrl;

	@Column(name = "character_model_url", length = 2083)
	private String characterModelUrl;

}