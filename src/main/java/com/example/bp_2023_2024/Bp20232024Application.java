package com.example.bp_2023_2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Bp20232024Application {

    public static void main(String[] args) {
        SpringApplication.run(Bp20232024Application.class, args);
    }

}
