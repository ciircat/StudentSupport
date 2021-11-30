package com.ciircat.studentsupport.restcontrollers;

import com.ciircat.studentsupport.entities.Pokus;
import com.ciircat.studentsupport.entities.Studium;
import com.ciircat.studentsupport.service.PokusService;
import com.ciircat.studentsupport.service.StudiumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PridatPokusyStudium {
    private StudiumService studiumService;
    private PokusService pokusService;

    public PridatPokusyStudium(StudiumService studiumService, PokusService pokusService){
        this.studiumService = studiumService;
        this.pokusService = pokusService;

    }
    @GetMapping("/pridat")
    public void pridat(){
        List<Studium> studia = this.studiumService.getAllStudiums();
        for (Studium studium : studia){
            List<Pokus> pokusy = this.pokusService.findPokusesByStudium(studium);
            studium.setPokusy(pokusy);
            this.studiumService.saveStudium(studium);
        }
    }
}
