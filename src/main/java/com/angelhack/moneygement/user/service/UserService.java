package com.angelhack.moneygement.user.service;

import java.util.Optional;

import com.angelhack.moneygement.asset.service.AssetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.angelhack.moneygement.user.dto.UserDto;
import com.angelhack.moneygement.user.entity.User;
import com.angelhack.moneygement.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final AssetService assetService;

	public ResponseEntity<Object> getUserInfo(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	public ResponseEntity<Object> userSignIn(UserDto userDto) {
		Optional<User> userOptional = userRepository.findById(userDto.getUserId());
		if (userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.get().getUserId());
		} else {
			User newUser = new User();
			newUser.setUserId(userDto.getUserId());
			newUser.setUserPw(userDto.getUserPw());
			userRepository.save(newUser);
			assetService.createAsset(userDto.getUserId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newUser.getUserId());
		}
	}
}

