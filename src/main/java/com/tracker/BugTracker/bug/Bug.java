package com.tracker.BugTracker.bug;

import com.tracker.BugTracker.comment.Comment;
import com.tracker.BugTracker.project.Project;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bug {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @OneToMany(mappedBy = "bug")
    private List<Comment> comments;

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
