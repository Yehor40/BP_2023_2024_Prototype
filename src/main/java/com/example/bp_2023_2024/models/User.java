package com.example.bp_2023_2024.models;

import jakarta.persistence.*;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

     // Example validation annotation
    private String username;


    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    public User() {
        // Default constructor
    }

    public User(Long user_id, String username, String password, UserRole role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters

    // Uncomment if you want to allow setting userId manually
    // public void setUserId(Long userId) {
    //     this.userId = userId;
    // }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
