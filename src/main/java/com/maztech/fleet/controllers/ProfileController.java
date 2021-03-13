package com.maztech.fleet.controllers;

import com.maztech.fleet.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("employee", employeeService.findEmployeeByUsername(username));
        return "profile";
    }
}
