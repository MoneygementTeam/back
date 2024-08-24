package com.angelhack.moneygement.monster.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "monster")
public class Monster extends BaseEntity {

    @Id
    @Column(name = "monster_id", length = 40)
    private String monsterId;

    @Column(name = "monster_name", length = 40)
    private String monsterName;

    @Column(name = "monster_desc", length = 2000)
    private String monsterDesc;

    @Column(name = "monster_image_url", length = 2083)
    private String monsterImageUrl;

    @Column(name = "monster_model_url", length = 2083)
    private String monsterModelUrl;
}