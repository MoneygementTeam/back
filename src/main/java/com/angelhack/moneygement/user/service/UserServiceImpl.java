package com.angelhack.moneygement.user.service;

import org.springframework.stereotype.Service;

import com.angelhack.moneygement.user.persistence.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

	private final UserRepository userRepository;
}

