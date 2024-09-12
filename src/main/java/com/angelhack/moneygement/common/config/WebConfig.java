package com.angelhack.moneygement.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOriginPatterns("*", "http://localhost:8080", "http://localhost:3000", "/**",
				"https://localhost:3000",
				"http://127.0.0.1:3000"
			)
			.allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP method
			.allowedHeaders("*")
			.allowCredentials(true);
	}
}
