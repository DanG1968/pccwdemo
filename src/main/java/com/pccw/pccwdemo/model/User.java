package com.pccw.pccwdemo.model;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    @Setter
    @Column(name = "U_NAME")
    private String username;

    @Setter
    @Column(name = "U_PASSWORD")
    private String password;

    @Setter
    @Column(name = "U_EMAIL")
    private String email;

    @Column(name = "enabled")
    private int enabled;

    public User() {
    }

    public User(Long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return enabled == users.enabled && Objects.equals(id, users.id) && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, enabled);
    }


}


