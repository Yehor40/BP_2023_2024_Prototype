package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

@Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long userId;
        private String username;
        private String password;
        private boolean isAdmin;

        // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}



