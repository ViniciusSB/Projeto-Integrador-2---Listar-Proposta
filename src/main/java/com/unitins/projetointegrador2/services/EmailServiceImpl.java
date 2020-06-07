package com.unitins.projetointegrador2.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("emailService")
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @org.springframework.scheduling.annotation.Async
    public void sendEmail(SimpleMailMessage email) {
        mailSender.send(email);
    }
}
