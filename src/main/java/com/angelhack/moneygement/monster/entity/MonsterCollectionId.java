package com.angelhack.moneygement.monster.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonsterCollectionId implements Serializable {
    private String userId;
    private String monsterId;
}
