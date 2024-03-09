package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.models.Project_Task;
import com.example.bp_2023_2024.repositories.TaskDepartmentRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskDepartmentRepository taskDepartmentRepository;

    public TaskService(TaskDepartmentRepository taskDepartmentRepository) {
        this.taskDepartmentRepository = taskDepartmentRepository;
    }

    public List<Project_Task> getAllTasks() {
        return taskDepartmentRepository.findAll();
    }

    public Optional<Project_Task> getTaskById(Long id) {
        return taskDepartmentRepository.findById(id);
    }

    public Project_Task createTask(Project_Task task) {
        return taskDepartmentRepository.save(task);
    }

    public Project_Task updateTask(Project_Task updatedtask,Long id) {
        Project_Task existingTask = new Project_Task();
        existingTask = taskDepartmentRepository.findById(id).orElseThrow();
        existingTask.setTaskName(updatedtask.getTaskName());
        existingTask.setDepartment(updatedtask.getDepartment());
        return taskDepartmentRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskDepartmentRepository.deleteById(id);
    }
}
