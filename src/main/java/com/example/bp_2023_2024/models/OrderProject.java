package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class OrderProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long orderId;
    private String project;


    @ManyToOne
    @JoinColumn(name = "taskId")
    private TaskDepartment taskDepartment;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToOne(mappedBy = "orderProject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OrderDetails orderDetails;


    //constructors,getters,setters

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


    public OrderProject(Long orderId, String project, TaskDepartment taskDepartment, List<User> users, OrderDetails orderDetails) {
        this.orderId = orderId;
        this.project = project;
        this.taskDepartment = taskDepartment;
        this.users = users;
        this.orderDetails = orderDetails;
    }
    public OrderProject(){}
}
