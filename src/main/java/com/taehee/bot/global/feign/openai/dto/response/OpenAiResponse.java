package com.taehee.bot.global.feign.openai.dto.response;

import java.util.List;

public record OpenAiResponse(
        List<Choice> choices
) {

    public record Choice(
            Message message
    ) {
    }

    public record Message(
            String content
    ) {
    }
}
