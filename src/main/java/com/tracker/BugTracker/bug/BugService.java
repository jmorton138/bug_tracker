package com.tracker.BugTracker.bug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugService {
    @Autowired
    public BugRepo bugRepo;

    public void addBug(Bug bug) {
        bugRepo.save(bug);
    }

    public List<Bug> getAllBugs() {
        return bugRepo.findAll();
    }

    public Bug getBugById(int id) {
        Optional<Bug> bugOptional = bugRepo.findById(id);
        Bug bug = null;
        if(bugOptional.isPresent()) {
            bug = bugOptional.get();
        } else {
            throw new RuntimeException("Bug not found for id ::" + id);
        }
        return bug;
    }

    public void updateBug(int id, Bug bug) {
        bugRepo.save(bug);
    }
    public void deleteBugById(int id) {
        bugRepo.deleteById(id);
    }
}
