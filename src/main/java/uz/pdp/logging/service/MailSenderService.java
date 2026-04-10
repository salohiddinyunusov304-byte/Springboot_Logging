package uz.pdp.logging.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailSenderService {
//    private static final Logger logger = Logger.getLogger(MailSenderService.class.getName());

    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    private final LogService logService;

    @Async
    public void sendMessage(String username) {
        logService.logInfo("/logs/sendText", "Send message to email: %s@gmail.com, id: %s".formatted(username, UUID.randomUUID()));

//        for (int i = 0; i < 10_000; i++) {
//            if (new Random().nextBoolean()) {
//                log.info("Send text :::: {}@gmail.com | id: {}", username, i);
//            } else {
//                log.error("Send texr :::: error | id : {}", i);
//
//            }
//        }

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            mimeMessage.setSubject("Hello " + username + " !!!");
            mimeMessage.setText("G58 Spring boot module 9");
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, username + "@gmail.com");
            mimeMessage.setFrom("from@gmail.com");

            javaMailSender.send(mimeMessage);
            System.out.println("Email sended successfuly: " + username + "@gmail.com");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}