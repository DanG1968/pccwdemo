package com.pccw.pccwdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pccw.pccwdemo.model.User;
import com.pccw.pccwdemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setId(1L);
        user.setUserName("testUser");
        user.setEmail("test@test.com");
        user.setPassword("password");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);
    }

    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(get("/api/user/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getUserById() throws Exception {
        mockMvc.perform(get("/api/user/find/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addUser() throws Exception {
        User user = new User();
        user.setUserName("testUser");
        user.setEmail("test@test.com");
        user.setPassword("password");

        mockMvc.perform(post("/api/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void updateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUserName("testUser");
        user.setEmail("test@test.com");
        user.setPassword("password");

        mockMvc.perform(put("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/api/user/delete/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAllUsers() throws Exception {
        mockMvc.perform(delete("/api/user/delete/all"))
                .andExpect(status().isOk());
    }

}
