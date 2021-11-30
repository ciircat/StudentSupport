package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.Pokus;
import com.ciircat.studentsupport.entities.Studium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokusRepository extends JpaRepository<Pokus, Long> {
    List<Pokus> findAllByStudium(Studium studium);
    @Query(value = "SELECT p from Pokus p WHERE p.akademickyRok='2017.0'")
    List<Pokus> findAllPokusesIn2017();
    @Query(value = "select p from Pokus p where p.akademickyRok='2017.0' and p.jdeOKonecnouZnamku=true and p.studium.vysledekPrvnihoRokuStudia='Pass'")
    List<Pokus> grznar();
    @Query(value = "select p from Pokus p where p.akademickyRok='2017.0' and p.jdeOKonecnouZnamku=true and p.studium.vysledekPrvnihoRokuStudia='Fail'")
    List<Pokus> grznarFail();
    @Query(value = "select p from Pokus p where p.akademickyRok='2018.0' and p.jdeOKonecnouZnamku=true and p.studium.vysledekPrvnihoRokuStudia='Pass'")
    List<Pokus> grznar2018();
    @Query(value = "select p from Pokus p where p.akademickyRok='2018.0' and p.jdeOKonecnouZnamku=true and p.studium.vysledekPrvnihoRokuStudia='Fail'")
    List<Pokus> grznarFail2018();

    @Query(value = "select p from Pokus p where p.akademickyRok='2019.0' and p.jdeOKonecnouZnamku=true and p.studium.vysledekPrvnihoRokuStudia='Pass'")
    List<Pokus> grznar2019();
    @Query(value = "select p from Pokus p where p.akademickyRok='2019.0' and p.jdeOKonecnouZnamku=true and p.studium.vysledekPrvnihoRokuStudia='Fail'")
    List<Pokus> grznarFail2019();



    @Query(value = "SELECT p from Pokus p WHERE p.akademickyRok=?1")
    List<Pokus> findAllPokusesInGivenYear(String year);
    @Query(value = "select p from Pokus p where p.akademickyRok=?1 and p.jdeOKonecnouZnamku=true and p.studium.vysledekPrvnihoRokuStudia=?2")
    List<Pokus> findAllPokusesByYearAndPassStatus(String year, String passStatus);
    @Query(value = "select p from Pokus p where p.akademickyRok=?1 and p.jdeOKonecnouZnamku=true and p.predmetSplnen=true group by p.studium order by p.tydenPokusu")
    List<Pokus> kokot(String akademickyRok);

    @Query(value = "select p from Pokus p where p.akademickyRok=?3 and p.studium.program.fakulta.nazevFakulty=?1 and p.studium.program.nazevProgramu=?2")
    List<Pokus>findAllPokusesByNazevFakultyAndNazevProgramuAndAkademickyRok(String nazevFakulty, String nazevProgramu, String akademickyRok);

}
