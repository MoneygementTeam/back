package com.angelhack.moneygement.monster.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "monster_collection")
@IdClass(MonsterCollectionId.class)
public class MonsterCollection extends BaseEntity {

    @Id
    @Column(name = "user_id", length = 40)
    private String userId;

    @Id
    @Column(name = "monster_id", length = 40)
    private String monsterId;
}
