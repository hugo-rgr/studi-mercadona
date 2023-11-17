package com.example.studimercadonafinal.security.admin;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table
public class Admin {
    @SequenceGenerator(
            name = "admin",
            schema = "public",
            allocationSize = 1
    )
    @Id
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
        if (login.matches("^[A-Za-z0-9_-]+$")) {
            this.login = login;
        } else {
            throw new IllegalArgumentException("Login should only include letters, numbers, underscores, and hyphens");
        }
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {

        if (pass.matches("^[A-Za-z0-9_-]+$")) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            this.pass = passwordEncoder.encode(pass);
        } else {
            throw new IllegalArgumentException("passwords should only include lowercase letters, numbers, underscores, and hyphens");
        }
    }
}
