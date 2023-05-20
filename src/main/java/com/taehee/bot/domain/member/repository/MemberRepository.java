package com.taehee.bot.domain.member.repository;

import com.taehee.bot.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
