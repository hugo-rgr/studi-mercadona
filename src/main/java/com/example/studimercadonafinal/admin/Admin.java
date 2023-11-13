package com.example.studimercadonafinal.admin;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;
    private String pass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.matches("^[a-z0-9_-]+$")) {
            this.login = login;
        } else {
            throw new IllegalArgumentException("Login should only include lowercase letters, numbers, underscores, and hyphens");
        }
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {

        if (pass.matches("^[a-z0-9_-]+$")) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            this.pass = passwordEncoder.encode(pass);
        } else {
            throw new IllegalArgumentException("passwords should only include lowercase letters, numbers, underscores, and hyphens");
        }
    }
}
