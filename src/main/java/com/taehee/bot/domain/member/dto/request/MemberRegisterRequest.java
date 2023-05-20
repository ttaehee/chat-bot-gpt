package com.taehee.bot.domain.member.dto.request;

import com.taehee.bot.domain.question.model.Category;

import javax.validation.constraints.NotBlank;

public record MemberRegisterRequest(
        @NotBlank(message = "이메일은 필수 입력사항입니다.")
        String email,

        @NotBlank(message = "질문 카테고리는 필수 입력사항입니다.")
        Category category
) {
}
