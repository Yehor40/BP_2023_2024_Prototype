package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.models.Project;
import com.example.bp_2023_2024.repositories.OrderProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private OrderProjectRepository orderProjectRepository;
    public List<Project> getAllProjects() {
        return orderProjectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {

        return orderProjectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return orderProjectRepository.save(project);
    }

    public Project saveProject(Project project) {
        return orderProjectRepository.save(project);
    }
    public void deleteProject(Long id) {
        orderProjectRepository.deleteById(id);
    }
}
