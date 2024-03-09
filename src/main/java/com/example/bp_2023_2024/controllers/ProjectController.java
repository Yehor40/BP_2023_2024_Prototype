package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.Project;
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
    public List<Project> getAllProjects() {
        return projects.getAllProjects();
    }
    @GetMapping("getProject/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projects.getProjectById(id);
        return project.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="createProject",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project newProject = projects.createProject(project);
        return ResponseEntity.ok(newProject);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable String id, @RequestBody Project project) {
        if (!project.getProjectId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Project updatedProject = projects.saveProject(project);
        return ResponseEntity.ok(updatedProject);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projects.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
