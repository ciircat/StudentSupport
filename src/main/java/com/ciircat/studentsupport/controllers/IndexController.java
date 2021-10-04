package com.ciircat.studentsupport.controllers;

import com.ciircat.studentsupport.commands.UserCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/","/login","","/index"})
    public String getIndex(Model model)
    {
        UserCommand userCommand = new UserCommand();
        model.addAttribute("uzivatelRegistrace", userCommand);
        return "index";
    }


}