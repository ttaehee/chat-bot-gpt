package com.taehee.bot.domain.question.application;

import com.taehee.bot.domain.member.model.Member;
import com.taehee.bot.domain.member.repository.MemberRepository;
import com.taehee.bot.domain.question.dto.response.SendQuestionResponse;
import com.taehee.bot.domain.question.model.QuestionGenerator;
import com.taehee.bot.global.sender.QuestionSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionGenerator questionGenerator;
    private final QuestionSender questionSender;
    private final MemberRepository memberRepository;

    @Transactional
    public void sendQuestion() {
        List<Member> members = memberRepository.findAll();
        members.parallelStream().forEach(
                member -> generateAndSend(member.getCategory().name(), member.getEmail())
        );
    }

    private void generateAndSend(String categoryName, String toAddress){
        SendQuestionResponse generatedQuestions = questionGenerator.generate(categoryName);
        questionSender.send(toAddress, generatedQuestions.combineToSting());
    }
}
