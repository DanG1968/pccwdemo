package com.pccw.pccwdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name="USERS")
public class Users {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    @Setter
    @Getter
    @Column(name = "U_NAME")
    private String name;

    @Setter
    @Getter
    @Column(name = "U_PASSWORD")
    private String password;

    @Setter
    @Getter
    @Column(name = "U_EMAIL")
    private String email;

    @Getter
    @Column(name = "enabled")
    private int enabled;

    public Users() {
    }

    public Users(Long id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return enabled == users.enabled && Objects.equals(id, users.id) && Objects.equals(name, users.name) && Objects.equals(password, users.password) && Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, enabled);
    }
}


