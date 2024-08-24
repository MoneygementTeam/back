package com.angelhack.moneygement.common.error;

import org.springframework.http.HttpStatus;

public record ErrorResponse(String errorMessage,HttpStatus status) {
}
