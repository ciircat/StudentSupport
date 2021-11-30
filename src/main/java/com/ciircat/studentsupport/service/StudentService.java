package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.Student;
import com.ciircat.studentsupport.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return this.studentRepository.save(student);
    }

    public Student findStudentByStudentovoId(String studentovoId){
        return this.studentRepository.findStudentByStudentovoId(studentovoId);
    }
}
