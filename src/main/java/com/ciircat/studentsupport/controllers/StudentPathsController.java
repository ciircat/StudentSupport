package com.ciircat.studentsupport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentPathsController {

    @GetMapping(value = "/studentPaths")
    public String getCoursesOverview(Model model){
        return "studentPaths";

    }
}
