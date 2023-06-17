package com.tracker.BugTracker.project;

import com.tracker.BugTracker.project.Project;
import com.tracker.BugTracker.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public String showProjectsList(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }

    @GetMapping("/project")
    public String addProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project";
    }
    @PostMapping("/project")
    public String addProject(@ModelAttribute("project") Project project) {
        projectService.addProject(project);
        return "redirect:/projects";
    }
}
