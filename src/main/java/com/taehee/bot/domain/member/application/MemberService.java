package com.taehee.bot.domain.member.application;

import com.taehee.bot.domain.member.dto.request.MemberRegisterRequest;
import com.taehee.bot.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.taehee.bot.domain.member.mapper.MemberMapper.toMember;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void registerMember(MemberRegisterRequest memberRegisterRequest) {
        memberRepository.save(toMember(memberRegisterRequest));
    }
}
