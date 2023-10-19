package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.models.OrderProject;
import com.example.bp_2023_2024.repositories.OrderProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private OrderProjectRepository orderProjectRepository;
    public List<OrderProject> getAllProjects() {
        return orderProjectRepository.findAll();
    }

    public Optional<OrderProject> getProjectById(String id) {

        return orderProjectRepository.findById(id);
    }

    public OrderProject createProject(OrderProject project) {
        return orderProjectRepository.save(project);
    }

    public OrderProject saveProject(OrderProject project) {
        return orderProjectRepository.save(project);
    }
    public void deleteProject(String id) {
        orderProjectRepository.deleteById(id);
    }
}
