package com.angelhack.moneygement.coin.entity;

import com.angelhack.moneygement.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "coin")
@IdClass(CoinId.class)
public class Coin extends BaseEntity {
    @Id
    @Column(name = "user_id", length = 40)
    private String userId;

    @Id
    @Column(name = "market", length = 10)
    private String market;

    @Column(name = "quantity")
    private BigDecimal quantity;
}
