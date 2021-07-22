package com.ciircat.studentsupport.controllers;

import com.ciircat.studentsupport.entities.User;
import com.ciircat.studentsupport.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class HomepageController {
    private final UserServiceImpl userService;

    @Autowired
    public HomepageController(UserServiceImpl userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/user/homepage")
    public String getHomepage(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails uzivatel = (UserDetails)principal;
        String username = uzivatel.getUsername();
        User user1 = this.userService.findByUsername(username);

/*
        String username;
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        model.addAttribute("username",username);*/
        model.addAttribute("user",uzivatel);
        return "homepage";
    }
}
