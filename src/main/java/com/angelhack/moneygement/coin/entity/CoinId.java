package com.angelhack.moneygement.coin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinId implements Serializable {
    private String userId;
    private String market;
}
