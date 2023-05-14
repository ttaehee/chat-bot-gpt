package com.taehee.bot.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class OpenFeignClientConfig {

    @Value("${openai.api-key}")
    private String apiKey;
}
