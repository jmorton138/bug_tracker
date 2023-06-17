package com.tracker.BugTracker.bug;

import com.tracker.BugTracker.bug.BugReportRepo;
import com.tracker.BugTracker.bug.BugReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugReportService {
    @Autowired
    public BugReportRepo bugReportRepo;

    public void addBugReport(BugReport bugReport) {
        bugReportRepo.save(bugReport);
    }

    public List<BugReport> getAllBugReports() {
        return bugReportRepo.findAll();
    }

    public BugReport getReportById(int id) {
        Optional<BugReport> bugReportOptional = bugReportRepo.findById(id);
        BugReport bugReport = null;
        if(bugReportOptional.isPresent()) {
            bugReport = bugReportOptional.get();
        } else {
            throw new RuntimeException("Report not found for id ::" + id);
        }
        return bugReport;
    }

    public void updateBugReport(int id, BugReport bugReport) {
        bugReportRepo.save(bugReport);
    }
    public void deleteReportById(int id) {
        bugReportRepo.deleteById(id);
    }
}
