package com.tracker.BugTracker.bug;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepo extends JpaRepository<Bug, Integer> {
}
