package com.example.bp_2023_2024.repositories;

import com.example.bp_2023_2024.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProjectRepository extends JpaRepository<Project, Long> {
}

