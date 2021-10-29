package com.ciircat.studentsupport.controllers;

import com.ciircat.studentsupport.entities.User;
import com.ciircat.studentsupport.repository.FakultaRepository;
import com.ciircat.studentsupport.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesOverviewController {
    private final UserServiceImpl userService;
    private final FakultaRepository fakultaRepository;

    @Autowired
    public CoursesOverviewController(UserServiceImpl userService, FakultaRepository fakultaRepository){
        this.userService = userService;
        this.fakultaRepository = fakultaRepository;
    }

    @GetMapping(value = "/coursesOverview")
    public String getCoursesOverview(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails uzivatel = (UserDetails)principal;
        String username = uzivatel.getUsername();
        User user1 = this.userService.findByUsername(username);
        var fakulty = this.fakultaRepository.findAll();
        model.addAttribute("fakulty",fakulty);
        return "coursesOverview";

    }

}
