package com.example.wiremock.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.wiremock.util.Constants.PACKAGE_NAME;

@SpringBootApplication(scanBasePackages = {PACKAGE_NAME})
public class WiremockApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiremockApplication.class, args);
    }
}
