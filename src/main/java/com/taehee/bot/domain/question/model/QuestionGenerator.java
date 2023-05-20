package com.taehee.bot.domain.question.model;

import com.taehee.bot.domain.question.dto.response.SendQuestionResponse;

public interface QuestionGenerator {
    SendQuestionResponse generate(String categoryName);
}
