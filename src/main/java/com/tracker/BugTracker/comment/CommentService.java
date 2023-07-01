package com.tracker.BugTracker.comment;

import com.tracker.BugTracker.bug.Bug;
import com.tracker.BugTracker.bug.BugRepo;
import com.tracker.BugTracker.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return bugRepo.findById(bugId).map(bug -> {
            comment.setBug(bug);
            comment.setAuthor(author);
            return commentRepo.save(comment);
        });
        //commentRepo.save(comment);
    }
}
