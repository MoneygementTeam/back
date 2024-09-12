package com.angelhack.moneygement.user.controller;

import com.angelhack.moneygement.common.external.ExternalApiProperties;
import com.angelhack.moneygement.common.external.OAuth2Service;
import com.angelhack.moneygement.common.external.dto.OauthUserInfoResponse;
import com.angelhack.moneygement.user.domain.LoginProvider;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "사용자 관리를 위한 API")
public class UserController {

    private final ExternalApiProperties externalApiProperties;
    private final OAuth2Service oAuth2Service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login/oauth2")
    public String login(Model model) {
        model.addAttribute("location", buildKakaoOAuthUrl());
        return "login";
    }

    @GetMapping("/login/oauth2/code")
    public ResponseEntity<OauthUserInfoResponse> getAuthCode(@RequestParam String code,
        @RequestParam(defaultValue = "kakao") String provider) {
        return ResponseEntity.ofNullable(oAuth2Service.processOAuth2User(LoginProvider.fromString(provider), code));
    }

    private String buildKakaoOAuthUrl() {
        return String.format(
            "%s/oauth/authorize?response_type=code&client_id=%s&redirect_uri=%s",
            externalApiProperties.getKakao().baseUri(),
            externalApiProperties.getKakao().apiKey(),
            externalApiProperties.getKakao().redirectUri()
        );
    }
}