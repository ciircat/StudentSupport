package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.Pokus;
import com.ciircat.studentsupport.entities.Studium;
import com.ciircat.studentsupport.repository.PokusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokusService {
    private PokusRepository pokusRepository;

    public PokusService(PokusRepository pokusRepository){
        this.pokusRepository = pokusRepository;
    }

    public Pokus savePokus(Pokus pokus){
        return this.pokusRepository.save(pokus);
    }

    public List<Pokus> findAllPokuses(){
        return this.pokusRepository.findAll();
    }

    public List<Pokus> findPokusesByStudium(Studium studium){
        return this.pokusRepository.findAllByStudium(studium);
    }


    public List<Pokus> findAllPokusesInGivenYear(String year){
        return this.pokusRepository.findAllPokusesInGivenYear(year);
    }

    public List<Pokus> findAllPokusesByYearAndPassStatus(String year, String passStatus){
        return this.pokusRepository.findAllPokusesByYearAndPassStatus(year, passStatus);
    }

    public List<Pokus> kokot(String rok){
        return this.pokusRepository.kokot(rok);
    }

    public List<Pokus>findAllPokusesByNazevFakultyAndNazevProgramuAndAkademickyRok(String nazevFakulty, String nazevProgramu, String akademickyRok){
        return this.pokusRepository.findAllPokusesByNazevFakultyAndNazevProgramuAndAkademickyRok(nazevFakulty,nazevProgramu,akademickyRok);
    }

}
