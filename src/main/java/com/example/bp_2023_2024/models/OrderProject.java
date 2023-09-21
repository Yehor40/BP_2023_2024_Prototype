package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class OrderProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String orderId;
    private String project;

    @ManyToOne
    @JoinColumn(name = "task_name")
    private TaskDepartment taskDepartment;

    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToMany
    private List<OrderDetails> orderDetailsList;

    //constructors,getters,setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


    public OrderProject(String orderId, String project, TaskDepartment taskDepartment, List<User> users, List<OrderDetails> orderDetailsList) {
        this.orderId = orderId;
        this.project = project;
        this.taskDepartment = taskDepartment;
        this.users = users;
        this.orderDetailsList = orderDetailsList;
    }
    public OrderProject(){}
}
