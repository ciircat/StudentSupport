package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByStudentovoId(String studentovoId);
}
