package com.example.bp_2023_2024.repositories;

import com.example.bp_2023_2024.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
