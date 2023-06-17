package com.tracker.BugTracker.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "project")
    private List<BugReport> bugReports;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
