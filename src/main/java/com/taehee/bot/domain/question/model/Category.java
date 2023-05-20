package com.taehee.bot.domain.question.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Category {
    DB,
    OS,
    Network,
    DataStructure;

    private static final String NOT_EXISTS_CATEGORY = "해당하는 카테고리가 없습니다.";

    @JsonCreator
    public static Category of(String categoryName) {
        return Arrays.stream(values())
                .filter(category -> category.name().equals(categoryName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_CATEGORY));
    }
}
