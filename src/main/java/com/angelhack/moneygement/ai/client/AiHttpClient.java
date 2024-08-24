package com.angelhack.moneygement.ai.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

@Deprecated
public interface AiHttpClient {
    ResponseEntity<Object> get(String uri);
    ResponseEntity<Object> post(String uri, Object data);
    HttpHeaders applyHeaders(String accessToken, HttpHeaders headers);
}
