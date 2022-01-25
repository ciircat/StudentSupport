package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.OborSpecializace;
import com.ciircat.studentsupport.entities.Student;
import com.ciircat.studentsupport.entities.Studium;
import com.ciircat.studentsupport.repository.StudiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudiumService {
    private StudiumRepository studiumRepository;

    @Autowired
    public StudiumService(StudiumRepository studiumRepository){
        this.studiumRepository = studiumRepository;
    }

    public Studium findStudiumByStudentAndOborSpecializace(Student student, OborSpecializace oborSpecializace){
        return this.studiumRepository.findStudiumByStudentAndOborSpecializace(student, oborSpecializace);
    }

    public Studium saveStudium(Studium studium){
        return this.studiumRepository.save(studium);
    }

    public List<Studium> getAllStudiums(){
        return this.studiumRepository.findAll();
    }


    public List<Studium> findAllStudiumsInGivenYear(String rok){
        return this.studiumRepository.findAllStudiumsByAkademickyRok(rok);
    }

    public List<Studium> findAllStudiumsByPassStatusAndAkademickyRok(String passStatus, String akademickyRok){
        return this.studiumRepository.findAllStudiumsByPassStatusAndAkademickyRok(passStatus,akademickyRok);
    }

    public int findAllStudiumsByAkademickyRokCount(String rok){
        return this.studiumRepository.findAllStudiumsByAkademickyRokCount(rok);
    }

    public int findAllStudiumsByPassStatusAndAkademickyRokCount(String passStatus, String rok){
        return this.studiumRepository.findAllStudiumsByPassStatusAndAkademickyRokCount(passStatus, rok);
    }
}