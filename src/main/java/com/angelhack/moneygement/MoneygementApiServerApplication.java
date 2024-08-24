package com.angelhack.moneygement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
public class MoneygementApiServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneygementApiServerApplication.class, args);
        log.info("Moneygement api server is running successfully!");
    }
}
