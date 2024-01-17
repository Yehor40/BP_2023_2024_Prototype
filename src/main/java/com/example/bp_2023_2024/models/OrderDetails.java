package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "taskId")
    private TaskDepartment taskDepartment;

    @OneToOne
    @JoinColumn(name = "order_id")  // Adjust the column name based on your actual database schema
    private OrderProject orderProject;
    private String timeSpent;
    private String realTime;
    private String charge;
    private String total;
    private Date handoverDate;
    private String state;
    private String month;

    public OrderDetails() {
    }

    // Constructors, getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public OrderProject getOrderProjects() {
        return orderProject;
    }

    public void setOrderProjects(OrderProject orderProject) {
        this.orderProject = orderProject;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getRealTime() {
        return realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Date getHandoverDate() {
        return handoverDate;
    }

    public void setHandoverDate(Date handoverDate) {
        this.handoverDate = handoverDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public TaskDepartment getTaskDepartment() {
        return taskDepartment;
    }

    public void setTaskDepartment(TaskDepartment taskDepartment) {
        this.taskDepartment = taskDepartment;
    }
}