package com.pccw.pccwdemo.controller;

import com.pccw.pccwdemo.dto.UserDTO;
import com.pccw.pccwdemo.model.User;
import com.pccw.pccwdemo.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Validated @RequestBody UserDTO userDTO) {
        // Map UserDTO to User
        User user = new User();
        user.setUsername(userDTO.getUserName());
        user.setEmail(userDTO.getEmailAddress());
        // Ideally, handle password securely
        user.setPassword(userDTO.getPassword());

        userRegistrationService.registerUser(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}

