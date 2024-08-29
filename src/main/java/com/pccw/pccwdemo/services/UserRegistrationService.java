package com.pccw.pccwdemo.services;

import com.pccw.pccwdemo.model.User;
import com.pccw.pccwdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        // Logic to save user to the database
        userRepository.save(user);

        // Send welcome email
        emailService.sendWelcomeEmail(user.getEmail(), user.getUserName());
    }
}
