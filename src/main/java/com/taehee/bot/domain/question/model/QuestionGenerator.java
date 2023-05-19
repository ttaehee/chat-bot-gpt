package com.taehee.bot.domain.question.model;

import java.util.List;

public interface QuestionGenerator {
    List<String> generate(String categoryName);
}
