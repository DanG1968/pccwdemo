package com.pccw.pccwdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmail(String toEmail, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Our Service");
        message.setText("Dear " + userName + ",\n\nThank you for registering with us. We're excited to have you on board!\n\nBest Regards,\nPCCW");

        mailSender.send(message);
    }
}
