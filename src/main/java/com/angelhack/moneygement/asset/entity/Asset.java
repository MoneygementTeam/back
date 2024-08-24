package com.angelhack.moneygement.asset.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import java.math.BigDecimal;

import com.angelhack.moneygement.common.entity.BaseEntity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "asset")
public class Asset extends BaseEntity {

    @Id
    @Column(name = "user_id", length = 40)
    private String userId;

    @Column(name = "asset_amount")
    private BigDecimal assetAmount;
}
