package com.tracker.BugTracker.bug;

import com.tracker.BugTracker.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BugReportController {
    @Autowired
    private BugReportService bugReportService;
    @Autowired
    private ProjectService projectService;
    @GetMapping("/")
    public String showReportsList(Model model) {
        model.addAttribute("reports", bugReportService.getAllBugReports());
        return "index";

    }
    @GetMapping("/bug-report")
    public String bugReportForm(Model model) {
        model.addAttribute("bugReport", new BugReport());
        model.addAttribute("projects", projectService.getAllProjects());
        return "bug-report";
    }

    @GetMapping("/bug-report/{id}")
    public String getBugReport(@PathVariable("id") int id, Model model) {
        BugReport bugReport = bugReportService.getReportById(id);
        model.addAttribute("report", bugReport);
        return "read-report";
    }

    @PostMapping("/bug-report")
    public String bugReportSubmit(@ModelAttribute("report") BugReport bugReport) {
        bugReportService.addBugReport(bugReport);
        return "redirect:/";
    }

    @PutMapping("/bug-report/{id}")
    public String updateBugReport(@PathVariable("id") int id, BugReport bugReport) {
        bugReportService.updateBugReport(id, bugReport);
        return "redirect:/";
    }

    @DeleteMapping("/delete-bug-report/{id}")
    public String deleteReport(@PathVariable("id") int id) {
        bugReportService.deleteReportById(id);
        return "redirect:/";
    }
}
