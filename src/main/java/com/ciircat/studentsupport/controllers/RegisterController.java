package com.ciircat.studentsupport.controllers;

import com.ciircat.studentsupport.commands.UserCommand;
import com.ciircat.studentsupport.converters.UserConverter;
import com.ciircat.studentsupport.entities.Univerzita;
import com.ciircat.studentsupport.entities.User;
import com.ciircat.studentsupport.repository.UniverzitaRepository;
import com.ciircat.studentsupport.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    private final UserServiceImpl uzivatelService;

    private final UserConverter userConverter;

    private final UniverzitaRepository univerzitaRepository;

    @Autowired
    public RegisterController(UserServiceImpl uzivatelService, UserConverter userConverter, UniverzitaRepository univerzitaRepository){
        this.uzivatelService = uzivatelService;
        this.userConverter = userConverter;
        this.univerzitaRepository = univerzitaRepository;

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(RedirectAttributes redirectAttributes, @ModelAttribute("uzivatelRegistrace") UserCommand userCommand){
        String heslo = userCommand.getPassword();
        String hesloZnovu = userCommand.getPasswordAgain();
        //Senior s = seniorService.findBySeniorsIdentificationCode(userCommand.getSeniorsIdentificationCode());
        Univerzita univerzita = univerzitaRepository.findUniverzitaByUniverzitniIdentifikacniKod(userCommand.getUniversityIdentificationCode());
        if (univerzita == null){
            redirectAttributes.addFlashAttribute("message","Univerzita s danným identifikačním kódem neexistuje");
            return "redirect:/index";
        }

        if (!heslo.equals(hesloZnovu)){
            redirectAttributes.addFlashAttribute("message","Zadané Heslo a Heslo znovu se neshodují");
            return "redirect:/index";

        }
        if (!uzivatelService.usernameIsUnique(userCommand.getUsername())){
            redirectAttributes.addFlashAttribute("message","Vámi zadané uživatelské jméno " + userCommand.getUsername() + " již existuje, zadejte prosím jiné");
            return "redirect:/index";

        }
        User user = userConverter.convert(userCommand);
        uzivatelService.save(user);


        return "index";
    }

}
