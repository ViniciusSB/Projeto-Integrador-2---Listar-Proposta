package com.unitins.projetointegrador2.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendEmail(SimpleMailMessage email);
}