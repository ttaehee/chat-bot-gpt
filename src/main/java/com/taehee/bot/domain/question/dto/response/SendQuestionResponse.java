package com.taehee.bot.domain.question.dto.response;

import com.taehee.bot.global.feign.openai.dto.response.OpenAiResponse;

import java.util.List;
import java.util.stream.Collectors;

public record SendQuestionResponse(
        List<String> questions
) {

    public static SendQuestionResponse toSendQuestionResponse(OpenAiResponse openAiResponse) {
        return new SendQuestionResponse(
                openAiResponse.choices().stream()
                        .map(choice -> choice.message().content())
                        .collect(Collectors.toList())
        );
    }

    public String combineToSting() {
        return  questions.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("/n"));
    }

}
