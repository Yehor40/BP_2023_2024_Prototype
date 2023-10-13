package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.models.TaskDepartment;
import com.example.bp_2023_2024.models.User;
import com.example.bp_2023_2024.repositories.TaskDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskDepartmentRepository taskDepartmentRepository;
    public List<TaskDepartment> getAllTasks() {
        return taskDepartmentRepository.findAll();
    }

    public Optional<TaskDepartment> getTaskById(String id) {
        return taskDepartmentRepository.findById(id);
    }

    public TaskDepartment createTask(TaskDepartment task) {
        return taskDepartmentRepository.save(task);
    }

    public TaskDepartment updateTask(TaskDepartment task) {
        return taskDepartmentRepository.save(task);
    }

    public void deleteTask(String id) {
        taskDepartmentRepository.deleteById(id);
    }
}
