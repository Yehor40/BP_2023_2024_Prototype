package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TaskDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    private String taskName;
    private String department;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<OrderDetails> taskOrders;

    // Constructors, getters, setters

    // Constructors
    public TaskDepartment() {
    }

    public TaskDepartment(String taskName, String department ,Integer taskId) {
        this.taskName = taskName;
        this.department = department;
        this.taskId= taskId;
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

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}


