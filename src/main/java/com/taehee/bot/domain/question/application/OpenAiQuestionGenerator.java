package com.taehee.bot.domain.question.application;

import com.taehee.bot.domain.question.dto.response.SendQuestionResponse;
import com.taehee.bot.domain.question.model.Category;
import com.taehee.bot.domain.question.model.QuestionGenerator;
import com.taehee.bot.global.config.OpenFeignClientConfig;
import com.taehee.bot.global.feign.openai.OpenAiChatClient;
import com.taehee.bot.global.feign.openai.dto.request.OpenAiRequest;
import com.taehee.bot.global.feign.openai.dto.response.OpenAiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.taehee.bot.domain.question.dto.response.SendQuestionResponse.toSendQuestionResponse;

@Component
@RequiredArgsConstructor
public class OpenAiQuestionGenerator implements QuestionGenerator {

    private final OpenAiChatClient openAiChatClient;
    private final OpenFeignClientConfig openFeignClientConfig;

    @Override
    public SendQuestionResponse generate(String categoryName) {
        OpenAiRequest openAiRequest = new OpenAiRequest(
                openFeignClientConfig.getModel(),
                List.of(new OpenAiRequest.Message(openFeignClientConfig.getRole(), Category.of(categoryName)))
        );

        OpenAiResponse openAiResponse = openAiChatClient.call(openAiRequest);

        return toSendQuestionResponse(openAiResponse);
    }
}
