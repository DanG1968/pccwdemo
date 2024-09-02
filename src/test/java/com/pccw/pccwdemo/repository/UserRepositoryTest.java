package com.pccw.pccwdemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.pccw.pccwdemo.model.User;
import com.pccw.pccwdemo.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName() {
        User user = new User();
        user.setUserName("testUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        userRepository.save(user);

        User foundUser = userRepository.findByUserName("testUser");
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUserName());
    }
}
