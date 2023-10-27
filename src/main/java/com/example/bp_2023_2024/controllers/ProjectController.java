package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.OrderDetails;
import com.example.bp_2023_2024.models.OrderProject;
import com.example.bp_2023_2024.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projects;
    @GetMapping("getProjects")
    public List<OrderProject> getAllProjects() {
        return projects.getAllProjects();
    }
    @GetMapping("getProject/{id}")
    public ResponseEntity<OrderProject> getProjectById(@PathVariable String id) {
        Optional<OrderProject> project = projects.getProjectById(id);
        return project.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="createProject",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderProject> createProject(@RequestBody OrderProject project) {
        OrderProject newProject = projects.createProject(project);
        return ResponseEntity.ok(newProject);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<OrderProject> updateProject(@PathVariable Long id, @RequestBody OrderProject project) {
        if (!project.getOrderId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        OrderProject updatedProject = projects.saveProject(project);
        return ResponseEntity.ok(updatedProject);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable String id) {
        projects.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
