package com.taehee.bot.domain.member.mapper;

import com.taehee.bot.domain.member.dto.request.MemberRegisterRequest;
import com.taehee.bot.domain.member.model.Member;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMapper {

    public static Member toMember(MemberRegisterRequest memberRegisterRequest){
        return new Member(memberRegisterRequest.email(), memberRegisterRequest.category());
    }
}
