package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TaskDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String taskName;
    private String department;

    @OneToMany(mappedBy = "taskDepartment")
    private List<OrderDetails> taskOrders;

    // Constructors, getters, setters

    // Constructors
    public TaskDepartment() {
    }

    public TaskDepartment(String taskName, String department) {
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
}


