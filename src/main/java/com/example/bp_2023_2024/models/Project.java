package com.example.bp_2023_2024.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long projectId;
    private String project;




    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;




    //constructors,getters,setters

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


    public Project(Long projectId, String project, Project_Task projectTask, List<User> users) {
        this.projectId = projectId;
        this.project = project;
        this.users = users;

    }
    public Project(){}
}
