package com.tracker.BugTracker.service;

import com.tracker.BugTracker.dao.ProjectRepo;
import com.tracker.BugTracker.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    public ProjectRepo projectRepo;

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public void addProject(Project project) {
        projectRepo.save(project);
    }
}
