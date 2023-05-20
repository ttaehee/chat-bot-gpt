package com.taehee.bot.global.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
public class QuestionEmailSender implements QuestionSender {

    @Value("${bot.mail}")
    private String fromAddress;

    private static final String SUBJECT = "[DailyTechInterview]오늘의 면접 질문입니다!";
    private static final String SEND_FAIL = "메일 전송에 실패하였습니다.";
    private static final String ENCODING = "UTF-8";

    private final JavaMailSender javaMailSender;

    @Async
    @Override
    public void send(String toAddress, String contents) {
        try {
            MimeMessage message = getMessage(toAddress, contents);
            javaMailSender.send(message);
        } catch (MessagingException exception) {
            throw new MailSendException(SEND_FAIL);
        }
    }

    private MimeMessage getMessage(String toAddress, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, false, ENCODING);

        messageHelper.setTo(toAddress);
        messageHelper.setFrom(fromAddress);
        messageHelper.setSubject(SUBJECT);
        messageHelper.setText(content);

        return message;
    }
}
