package com.tracker.BugTracker.dao;

import com.tracker.BugTracker.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
