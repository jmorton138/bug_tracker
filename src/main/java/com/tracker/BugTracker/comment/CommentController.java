package com.tracker.BugTracker.comment;

import com.tracker.BugTracker.bug.BugService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/bug-report/{bugId}/comments")
    public String addComment(@PathVariable(value = "bugId") int bugId, @ModelAttribute("comment") Comment comment) {
        commentService.addComment(comment, bugId);
        return "redirect:/bug-report/{bugId}";
    }
}
