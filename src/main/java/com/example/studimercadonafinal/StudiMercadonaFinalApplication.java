package com.example.studimercadonafinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class StudiMercadonaFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudiMercadonaFinalApplication.class, args);
    }

}
