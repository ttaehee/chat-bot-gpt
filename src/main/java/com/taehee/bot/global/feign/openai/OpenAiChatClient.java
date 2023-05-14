package com.taehee.bot.global.feign.openai;

import com.taehee.bot.global.config.OpenFeignClientConfig;
import com.taehee.bot.global.feign.openai.dto.request.OpenAiRequest;
import com.taehee.bot.global.feign.openai.dto.response.OpenAiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OpenAiChatClient", url = "${openai.url}", configuration = OpenFeignClientConfig.class)
public interface OpenAiChatClient {
    @PostMapping
    OpenAiResponse call(@RequestBody OpenAiRequest openAiRequest);
}
