package com.ciircat.studentsupport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesOverviewController {

    @GetMapping(value = "/coursesOverview")
    public String getCoursesOverview(Model model){
        return "coursesOverview";

    }

}
