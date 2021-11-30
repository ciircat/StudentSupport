package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.Predmet;
import com.ciircat.studentsupport.repository.PredmetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredmetService {
    private PredmetRepository predmetRepository;

    public PredmetService(PredmetRepository predmetRepository){
        this.predmetRepository = predmetRepository;
    }

    public Predmet savePredmet(Predmet predmet){
        return this.predmetRepository.save(predmet);
    }

    public Predmet findPredmetByNazevPredmetu(String nazevPredmetu){
        return this.predmetRepository.findPredmetByNazevPredmetu(nazevPredmetu);
    }

    public Predmet findById(Long id){
        Optional<Predmet> predmet = this.predmetRepository.findById(id);
        if (predmet.isPresent()){
            return predmet.get();
        }else {
            return null;
        }
    }

    public List<Predmet> kokot(String nazevFakulty, String nazevProgramu, String akademickyRok){
        return this.predmetRepository.kokot(nazevFakulty, nazevProgramu, akademickyRok);
    }

}
