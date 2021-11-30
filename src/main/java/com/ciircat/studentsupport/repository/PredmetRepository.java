package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {
    Predmet findPredmetByNazevPredmetu(String nazevPredmetu);

    @Query(value = "select distinct y from Pokus p join p.predmet y where p.akademickyRok=?3 and p.studium.program.fakulta.nazevFakulty=?1 and p.studium.program.nazevProgramu=?2 and p.predmet.pocetKreditu > 0 and p.predmet.typUkonceni<>'zápočet'")
    List<Predmet> kokot(String nazevFakulty, String nazevProgramu, String akademickyRok);
}
