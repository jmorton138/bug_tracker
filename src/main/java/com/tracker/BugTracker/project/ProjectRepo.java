package com.tracker.BugTracker.project;

import com.tracker.BugTracker.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
