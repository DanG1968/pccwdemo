package com.pccw.pccwdemo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserDTOTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("testUser");
        userDTO.setEmailAddress("test@example.com");
        userDTO.setPassword("testPassword");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testUserNameNullOrEmpty() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(null);  // This is the field under test, invalid
        userDTO.setEmailAddress("test@example.com");  // Valid
        userDTO.setPassword("password");  // Valid

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        // Expecting two violations: one for @NotNull and one for @NotEmpty
        assertEquals(2, violations.size());
    }

    @Test
    public void testEmailAddressInvalid() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("testUser");
        userDTO.setEmailAddress("invalid-email");
        userDTO.setPassword("testPassword");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());

        ConstraintViolation<UserDTO> violation = violations.iterator().next();
        assertEquals("must be a well-formed email address", violation.getMessage());
    }

    @Test
    public void testPasswordNullOrEmpty() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("testUser");  // Valid
        userDTO.setEmailAddress("test@example.com");  // Valid
        userDTO.setPassword(null);  // This is the field under test, invalid

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        // Expecting two violations: one for @NotNull and one for @NotEmpty
        assertEquals(2, violations.size());
    }

}
