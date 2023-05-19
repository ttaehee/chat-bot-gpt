package com.taehee.bot.domain.question.service;

import com.taehee.bot.domain.question.model.Category;
import com.taehee.bot.domain.question.model.QuestionGenerator;
import com.taehee.bot.global.config.OpenFeignClientConfig;
import com.taehee.bot.global.feign.openai.OpenAiChatClient;
import com.taehee.bot.global.feign.openai.dto.request.OpenAiRequest;
import com.taehee.bot.global.feign.openai.dto.response.OpenAiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OpenAiQuestionGenerator implements QuestionGenerator {

    private final OpenAiChatClient openAiChatClient;
    private final OpenFeignClientConfig openFeignClientConfig;

    @Override
    public List<String> generate(String categoryName) {
        OpenAiRequest openAiRequest = new OpenAiRequest(
                openFeignClientConfig.getModel(),
                List.of(new OpenAiRequest.Message(openFeignClientConfig.getRole(), Category.of(categoryName)))
        );

        OpenAiResponse openAiResponse = openAiChatClient.call(openAiRequest);

        //TODO dto로 변환하기 고려
        return openAiResponse.choices().stream()
                .map(choice -> choice.message().content())
                .collect(Collectors.toList());
    }
}
