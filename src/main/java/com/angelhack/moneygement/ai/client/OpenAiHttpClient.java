package com.angelhack.moneygement.ai.client;

import com.angelhack.moneygement.common.config.ApiKeyConfig;
import com.angelhack.moneygement.common.util.HttpClientUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.angelhack.moneygement.common.constant.HeaderConstant.OPEN_AI_AUTHORIZATION_PREFIX;

@Slf4j
@Component
@RequiredArgsConstructor
@Deprecated
public class OpenAiHttpClient implements AiHttpClient {

    private final ApiKeyConfig apiKeyConfig;

    @Override
    public ResponseEntity<Object> get(String uri) {
        return HttpClientUtil.get(applyHeaders(apiKeyConfig.getOpenAiApiKey(), new HttpHeaders()), uri);
    }

    @Override
    public ResponseEntity<Object> post(String uri, Object data) {
        return HttpClientUtil.post(applyHeaders(apiKeyConfig.getOpenAiApiKey(), new HttpHeaders()), uri, data);
    }

    @Override
    public HttpHeaders applyHeaders(String apiKey, HttpHeaders headers) {
        headers.set(HttpHeaders.AUTHORIZATION, OPEN_AI_AUTHORIZATION_PREFIX.getValue().concat(apiKey));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
