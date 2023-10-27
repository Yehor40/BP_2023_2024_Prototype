package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.TaskDepartment;
import com.example.bp_2023_2024.models.User;
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
    public List<TaskDepartment> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("getTask/{id}")
    public ResponseEntity<TaskDepartment> getTaskById(@PathVariable String id) {
        Optional<TaskDepartment> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="createTask",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDepartment> createTask(@RequestBody TaskDepartment task) {
        TaskDepartment newTask = taskService.createTask(task);
        return ResponseEntity.ok(newTask);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<TaskDepartment> updateTask(@PathVariable Long id, @RequestBody TaskDepartment task) {
        if (!task.getTaskId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        TaskDepartment updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
