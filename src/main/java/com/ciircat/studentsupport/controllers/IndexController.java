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

    @RequestMapping({"/loginfailed"})
    public String getFailedLogin(Model model) {
        UserCommand userCommand = new UserCommand();
        model.addAttribute("uzivatelRegistrace", userCommand);
        model.addAttribute("message", "Spatně zadané uživatelské jméno a heslo");
        return "index";
    }


}