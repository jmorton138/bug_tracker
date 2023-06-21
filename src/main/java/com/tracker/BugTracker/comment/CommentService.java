package com.tracker.BugTracker.comment;

import com.tracker.BugTracker.bug.Bug;
import com.tracker.BugTracker.bug.BugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    public CommentRepo commentRepo;
    @Autowired
    public BugRepo bugRepo;

    public List<Comment> getAllComments(int bugId) {
        return commentRepo.findAllByBugId(bugId);
    }
    public Optional<Comment> addComment(Comment comment, int bugId) {
        return bugRepo.findById(bugId).map(bug -> {
            comment.setBug(bug);
            return commentRepo.save(comment);
        });
        //commentRepo.save(comment);
    }
}
