package com.angelhack.moneygement.common.constant;

import lombok.Getter;

@Getter
@Deprecated
public enum OpenAiConstant {
    MODEL_GPT_4O("gpt-4o");

    private final String value;

    OpenAiConstant(String value) {
        this.value = value;
    }
}
