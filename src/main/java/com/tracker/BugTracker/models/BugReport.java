package com.tracker.BugTracker.models;

import jakarta.persistence.*;

@Entity
public class BugReport {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
