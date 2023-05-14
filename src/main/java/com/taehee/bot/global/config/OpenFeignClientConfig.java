package com.taehee.bot.global.config;

import feign.RequestInterceptor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@EnableFeignClients("com.taehee.bot.global.feign.openai")
public class OpenFeignClientConfig {

    @Value("${openai.api-key}")
    private String apiKey;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.role}")
    private String role;

    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return requestTemplate -> requestTemplate.header("Authorization", apiKey);
    }
}
