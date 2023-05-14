package com.taehee.bot.global.feign.openai.dto.response;

import com.taehee.bot.global.feign.openai.dto.Message;

import java.util.List;

public record OpenAiResponse(
        List<Message> choices
) {
}
