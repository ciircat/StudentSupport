package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.DataLineGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataLineGraphRepository extends JpaRepository<DataLineGraph, Long> {
    DataLineGraph findDataLineGraphByNazevUniverzityAndNazevFakultyAndNazevProgramuAndKodProgramuAndNazevOboruSpecializaceAndAkademickyRok(String nazevUniverzity, String nazevFakulty, String nazevProgramu, String kodProgramu, String kodOboruSpecializace, String akademickyRok);

    DataLineGraph findDataLineGraphByNazevFakultyAndNazevProgramuAndAkademickyRok(String nazevFakulty, String nazevProgramu, String akademickyRok);
}
