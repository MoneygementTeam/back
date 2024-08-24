package com.angelhack.moneygement.ai.service;

import com.angelhack.moneygement.common.config.ChatClientConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiChatService {

	private final ChatClient chatClient;
	private final ChatClientConfig config;

	public ResponseEntity<Object> sendChatForFun(String prompt) {
		return ResponseEntity.status(HttpStatus.OK).body(sendChatToAi(config.getFunnySystemText(), prompt));
	}

	public ResponseEntity<Object> sendChatForAnalyticalFeedback(String prompt) {
		return ResponseEntity.status(HttpStatus.OK).body(sendChatToAi(config.getAnalyticalFeedbackSystemText(), prompt));
	}

	public String sendChatToAi(String systemText, String prompt) {
		return chatClient.prompt()
			.system(systemText)
			.user(prompt)
			.call()
			.content();
	}
}

