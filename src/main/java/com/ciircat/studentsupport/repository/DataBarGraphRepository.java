package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.DataBarGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataBarGraphRepository extends JpaRepository<DataBarGraph, Long> {
    @Query(value = "select d from DataBarGraph d where d.nazevfakulty=?1 and d.nazevProgramu=?2 and d.akademickyRok=?3 and d.week=?4")
    DataBarGraph getDataBarGraphByNazevfakultyAndNazevProgramuAndAkademickyRokAAndWeek(String nazevFakulty, String nazevProgramu, String akademickyRok, int week);
}
