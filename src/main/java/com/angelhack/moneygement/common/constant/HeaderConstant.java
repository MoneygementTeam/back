package com.angelhack.moneygement.common.constant;

import lombok.Getter;

@Getter
@Deprecated
public enum HeaderConstant {
    // Open AI
    OPEN_AI_AUTHORIZATION_PREFIX("Bearer ");

    private final String value;

    HeaderConstant(String value) {
        this.value = value;
    }
}
