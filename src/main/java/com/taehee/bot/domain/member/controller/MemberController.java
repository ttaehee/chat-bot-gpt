package com.taehee.bot.domain.member.controller;

import com.taehee.bot.domain.member.application.MemberService;
import com.taehee.bot.domain.member.dto.request.MemberRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> registerMember(
            @RequestBody @Valid MemberRegisterRequest memberRegisterRequest) {
        memberService.registerMember(memberRegisterRequest);
        return ResponseEntity.ok().build();
    }
}
