package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.DataBarGraph;
import com.ciircat.studentsupport.repository.DataBarGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class DataBarGraphService {
    private DataBarGraphRepository dataBarGraphRepository;

    @Autowired
    public DataBarGraphService(DataBarGraphRepository dataBarGraphRepository){
        this.dataBarGraphRepository = dataBarGraphRepository;
    }

    public DataBarGraph saveDataBarGraph(DataBarGraph dataBarGraph){
        return this.dataBarGraphRepository.save(dataBarGraph);
    }

    public DataBarGraph getDataBarGraphByNazevfakultyAndNazevProgramuAndAkademickyRok(String nazevFakulty, String nazevProgramu, String akademickyRok, String value){
        Integer week = Integer.parseInt(value);
        return this.dataBarGraphRepository.getDataBarGraphByNazevfakultyAndNazevProgramuAndAkademickyRokAAndWeek(nazevFakulty,nazevProgramu,akademickyRok, week);
    }

}
