package com.taehee.bot.global.feign.openai.dto;

public record Message(
        String role,
        String content
) {
}
