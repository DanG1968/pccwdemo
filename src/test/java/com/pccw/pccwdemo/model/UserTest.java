package com.pccw.pccwdemo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        String userName = "testUser";
        String password = "testPassword";
        String email = "test@example.com";

        User user = new User(id, userName, password, email);

        assertEquals(id, user.getId());
        assertEquals(userName, user.getUserName());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testSetters() {
        User user = new User();

        Long id = 1L;
        String userName = "testUser";
        String password = "testPassword";
        String email = "test@example.com";

        user.setId(id);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);

        assertEquals(id, user.getId());
        assertEquals(userName, user.getUserName());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testEqualsAndHashCode() {
        User user1 = new User(1L, "testUser", "testPassword", "test@example.com");
        User user2 = new User(1L, "testUser", "testPassword", "test@example.com");
        User user3 = new User(2L, "testUser2", "testPassword2", "test2@example.com");

        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertEquals(user1.hashCode(), user2.hashCode());
        assertNotEquals(user1.hashCode(), user3.hashCode());
    }

    @Test
    public void testEnabledField() {
        User user = new User();
        user.setEnabled(1);
        assertEquals(1, user.getEnabled());
    }

    @Test
    public void testEmptyConstructor() {
        User user = new User();
        assertNull(user.getId());
        assertNull(user.getUserName());
        assertNull(user.getPassword());
        assertNull(user.getEmail());
    }
}

