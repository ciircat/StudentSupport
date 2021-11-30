package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.DataLineGraph;
import com.ciircat.studentsupport.repository.DataLineGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLineGraphService {
    private DataLineGraphRepository dataLineGraphRepository;

    @Autowired
    public DataLineGraphService(DataLineGraphRepository dataLineGraphRepository){
        this.dataLineGraphRepository = dataLineGraphRepository;
    }

    public DataLineGraph saveDataLineGrap(DataLineGraph dataLineGraph){
        return this.dataLineGraphRepository.save(dataLineGraph);
    }

    public DataLineGraph findDataLineGraphByNazevUniverzityAndNazevFakultyAndNazevProgramuAndKodProgramuAndNazevOboruSpecializaceAndAkademickyRok(String nazevUniverzity, String nazevFakulty, String nazevProgramu, String kodProgramu, String kodOboruSpecializace, String akademickyRok){
        return this.dataLineGraphRepository.findDataLineGraphByNazevUniverzityAndNazevFakultyAndNazevProgramuAndKodProgramuAndNazevOboruSpecializaceAndAkademickyRok(nazevUniverzity,nazevFakulty,nazevProgramu,kodProgramu,kodOboruSpecializace,akademickyRok);
    }

    public  DataLineGraph findDataLineGraphByNazevFakultyAndNazevProgramuAndAkademickyRok(String nazevFakulty, String nazevProgramu, String akademickyRok){
        return this.dataLineGraphRepository.findDataLineGraphByNazevFakultyAndNazevProgramuAndAkademickyRok(nazevFakulty,nazevProgramu,akademickyRok);
    }
}
