package com.example.bp_2023_2024.repositories;

import com.example.bp_2023_2024.models.Project_Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDepartmentRepository extends JpaRepository<Project_Task, Long> {
}
