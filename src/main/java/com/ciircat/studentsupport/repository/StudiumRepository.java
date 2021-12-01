package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.OborSpecializace;
import com.ciircat.studentsupport.entities.Student;
import com.ciircat.studentsupport.entities.Studium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudiumRepository extends JpaRepository<Studium, Long> {
    Studium findStudiumByStudentAndOborSpecializace(Student student, OborSpecializace oborSpecializace);

    @Query(value = "SELECT s from Studium s WHERE s.rokMaturitniZkousky=?1")
    List<Studium> findAllStudiumsByAkademickyRok(String rok);

    @Query(value = "SELECT s from Studium s WHERE s.vysledekPrvnihoRokuStudia = ?1 and s.rokMaturitniZkousky=?2")
    List<Studium> findAllStudiumsByPassStatusAndAkademickyRok(String passStatus, String rok);





}