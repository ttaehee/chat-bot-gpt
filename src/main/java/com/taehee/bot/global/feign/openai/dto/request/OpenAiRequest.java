package com.taehee.bot.global.feign.openai.dto.request;

import com.taehee.bot.global.feign.openai.dto.Message;

import java.util.List;

public record OpenAiRequest(
        String model,
        List<Message> messages
) {
}
