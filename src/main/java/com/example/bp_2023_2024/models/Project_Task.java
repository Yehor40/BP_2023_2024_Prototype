package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project_Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String taskName;
    private String department;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_task",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    // Constructors, getters, setters

    // Constructors
    public Project_Task() {
    }

    public Project_Task(Long taskId, String taskName, String department) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.department = department;
    }

    // Getters and setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}


