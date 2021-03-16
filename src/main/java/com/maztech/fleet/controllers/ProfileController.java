package com.maztech.fleet.controllers;

import com.maztech.fleet.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @PostMapping("/profile/uploadPhoto")
    public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal)
            throws IllegalStateException, IOException {
        String baseDirectory = "C:\\Users\\maztech\\eclipse-workspace-2020\\fleet\\src\\main\\resources\\static\\img\\userPhotos\\";
        file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
        return "redirect:/profile";
    }
}
