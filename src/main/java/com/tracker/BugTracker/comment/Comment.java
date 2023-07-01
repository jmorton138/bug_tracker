package com.tracker.BugTracker.comment;

import com.tracker.BugTracker.bug.Bug;
import com.tracker.BugTracker.user.User;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int Id;
    private String body;

    @ManyToOne
    @JoinColumn(name="bug_id")
    private Bug bug;

    @OneToOne
    private User author;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Bug getBug() {
        return bug;
    }

    public void setBug(Bug bug) {
        this.bug = bug;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
