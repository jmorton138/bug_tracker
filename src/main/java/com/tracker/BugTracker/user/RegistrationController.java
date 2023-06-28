package com.tracker.BugTracker.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @GetMapping("user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        //UserDto userDto = new UserDto();
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("user/registration")
    public String registerUser(@ModelAttribute("user") User user) {
        // if already exists
        userService.saveUser(user);
        return "redirect:/";
    }



}