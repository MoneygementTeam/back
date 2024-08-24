package com.angelhack.moneygement.user.controller;

import com.angelhack.moneygement.user.dto.UserDto;
import com.angelhack.moneygement.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "User Controller", description = "사용자 관리를 위한 API")
public class UserController {

    private final UserService service;

    @PostMapping("/signin")
    @Operation(summary = "User sign in", description = "특정 사용자 정보로 로그인합니다.")
    public ResponseEntity<Object> userSignIn(
            @RequestBody UserDto userDto) {
        return service.userSignIn(userDto);
    }
}
