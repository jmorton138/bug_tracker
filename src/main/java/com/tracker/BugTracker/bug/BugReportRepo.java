package com.tracker.BugTracker.bug;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BugReportRepo extends JpaRepository<BugReport, Integer> {
}
