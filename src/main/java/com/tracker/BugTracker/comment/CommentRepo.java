package com.tracker.BugTracker.comment;

import com.tracker.BugTracker.bug.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByBugId(int bugId);
}
