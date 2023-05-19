package com.taehee.bot.global.feign.openai.dto.request;

import com.taehee.bot.domain.question.model.Category;

import java.util.List;

public record OpenAiRequest(
        String model,
        List<Message> messages
) {

    public record Message(
            String role,
            String content
    ) {
        public Message(String role, Category categoryName) {
            this(role, categoryName + " 관련 백엔드 개발자 면접 질문 10개씩 한글로 번역해서 json 형식으로 줘");
        }
    }
}
