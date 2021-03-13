package com.maztech.fleet.controllers;

import com.maztech.fleet.entities.User;
import com.maztech.fleet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getUsers(){
        return "user";
    }

    //Add New User (register)
    @PostMapping(value = "users/addNew")
    public RedirectView addUser(@Valid User user, RedirectAttributes redir) {

       userService.saveUser(user);
       RedirectView redirectView = new RedirectView("/login",true);
       redir.addFlashAttribute("message","You Successfully Registred! You can login now");
       return redirectView;
    }
}
