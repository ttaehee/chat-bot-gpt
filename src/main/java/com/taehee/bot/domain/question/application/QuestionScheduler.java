package com.taehee.bot.domain.question.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionScheduler {

    private final QuestionService questionService;

    @Scheduled(cron = "0 0 5 * * *")
    public void sendQuestionScheduling() {
        String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        log.info(MessageFormat.format("{0} - [QuestionService] send questions start", startTime));

        questionService.sendQuestion();

        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        log.info(MessageFormat.format("{0} - [QuestionSender] send questions end", endTime));
    }
}
