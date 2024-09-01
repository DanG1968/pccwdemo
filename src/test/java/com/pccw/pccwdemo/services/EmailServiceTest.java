package com.pccw.pccwdemo.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSendWelcomeEmail() {
        MockitoAnnotations.openMocks(this);
        
        String toEmail = "test@example.com";
        String userName = "testUser";

        emailService.sendWelcomeEmail(toEmail, userName);

        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(toEmail);
        expectedMessage.setSubject("Welcome to Our Service");
        expectedMessage.setText("Dear " + userName + ",\n\nThank you for registering with us. We're excited to have you on board!\n\nBest Regards,\nPCCW");

        verify(mailSender, times(1)).send(expectedMessage);
    }
}
