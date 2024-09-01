package com.pccw.pccwdemo.controller;

import com.pccw.pccwdemo.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.pccw.pccwdemo.controller.UserRegistrationController;
import com.pccw.pccwdemo.services.UserRegistrationService;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.doNothing;

@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRegistrationService userRegistrationService;

    @InjectMocks
    private UserRegistrationController userRegistrationController;

    @Test
    public void testRegisterUser() throws Exception {
        MockitoAnnotations.openMocks(this);

        doNothing().when(userRegistrationService).registerUser(any(User.class));

        mockMvc.perform(post("/api/users/register")
            .contentType("application/json")
            .content("{\"userName\": \"testUser\", \"emailAddress\": \"test@example.com\", \"password\": \"password\"}"))
            .andExpect(status().isOk())
            .andExpect(content().string("User registered successfully!"));
    }
}
