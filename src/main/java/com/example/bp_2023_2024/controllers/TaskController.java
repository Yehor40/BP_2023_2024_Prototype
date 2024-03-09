package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.Project_Task;
import com.example.bp_2023_2024.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("getTasks")
    public List<Project_Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("getTask/{id}")
    public ResponseEntity<Project_Task> getTaskById(@PathVariable Long id) {
        Optional<Project_Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="createTask",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project_Task> createTask(@RequestBody Project_Task task) {
        Project_Task newTask = taskService.createTask(task);
        return ResponseEntity.ok(newTask);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Project_Task> updateTask(@PathVariable Long id, @RequestBody Project_Task task) {
        if (!task.getTaskId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Project_Task updatedTask = taskService.updateTask(task, id);
        return ResponseEntity.ok(updatedTask);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
