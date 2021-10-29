package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.Fakulta;
import com.ciircat.studentsupport.entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program,Long> {
    List<Program> findProgramsByFakulta(Fakulta fakulta);
}
