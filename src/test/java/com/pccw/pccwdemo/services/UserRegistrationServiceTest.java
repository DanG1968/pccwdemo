package com.pccw.pccwdemo.services;

import com.pccw.pccwdemo.model.User;
import com.pccw.pccwdemo.repository.UserRepository;
import com.pccw.pccwdemo.services.EmailService;
import com.pccw.pccwdemo.services.UserRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserRegistrationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private UserRegistrationService userRegistrationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setUserName("testUser");

        // Act
        userRegistrationService.registerUser(user);

        // Assert
        verify(userRepository, times(1)).save(user);
        verify(emailService, times(1)).sendWelcomeEmail("test@example.com", "testUser");
    }
}

