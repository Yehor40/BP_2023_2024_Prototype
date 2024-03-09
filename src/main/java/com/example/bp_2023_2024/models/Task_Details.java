package com.example.bp_2023_2024.models;
import jakarta.persistence.*;
@Entity
public class Task_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detail_id;
    @OneToOne
    @JoinColumn(name = "task_id")  // Adjust the column name based on your actual database schema
    private Project_Task task;
    private String timeSpent;
    private String realTime;
    private String charge;
    private String total;
    private String state;
    private String month;
    public Task_Details() {
    }
    public Long getId() {
        return detail_id;
    }
    public void setId(Long id) {
        this.detail_id = id;
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
    public Project_Task getTaskDepartment() {
        return task;
    }
    public void setTaskDepartment(Project_Task task) {
        this.task = task;
    }
}