package com.tracker.BugTracker.dao;

import com.tracker.BugTracker.models.BugReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BugReportRepo extends JpaRepository<BugReport, Integer> {
}
