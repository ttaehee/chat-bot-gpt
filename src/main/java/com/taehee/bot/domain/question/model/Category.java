package com.taehee.bot.domain.question.model;

import java.util.Arrays;

public enum Category {
    DB,
    OS,
    Network,
    DataStructure;

    private static final String NOT_EXISTS_CATEGORY = "해당하는 카테고리가 없습니다.";

    public static Category of(String categoryName) {
        return Arrays.stream(values())
                .filter(category -> category.toString().equals(categoryName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_CATEGORY));
    }
}
