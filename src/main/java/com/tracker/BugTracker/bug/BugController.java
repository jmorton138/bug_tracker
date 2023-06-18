package com.tracker.BugTracker.bug;

import com.tracker.BugTracker.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BugController {
    @Autowired
    private BugService bugService;
    @Autowired
    private ProjectService projectService;
    @GetMapping("/")
    public String showBugsList(Model model) {
        model.addAttribute("reports", bugService.getAllBugs());
        return "index";

    }
    @GetMapping("/bug-report")
    public String bugForm(Model model) {
        model.addAttribute("bug", new Bug());
        model.addAttribute("projects", projectService.getAllProjects());
        return "bug-report";
    }

    @GetMapping("/bug-report/{id}")
    public String getBug(@PathVariable("id") int id, Model model) {
        Bug bug = bugService.getBugById(id);
        model.addAttribute("report", bug);
        return "read-report";
    }

    @PostMapping("/bug-report")
    public String bugSubmit(@ModelAttribute("report") Bug bug) {
        bugService.addBug(bug);
        return "redirect:/";
    }

    @PutMapping("/bug-report/{id}")
    public String updateBug(@PathVariable("id") int id, Bug bug) {
        bugService.updateBug(id, bug);
        return "redirect:/";
    }

    @DeleteMapping("/delete-bug-report/{id}")
    public String deleteBug(@PathVariable("id") int id) {
        bugService.deleteBugById(id);
        return "redirect:/";
    }
}
