package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.Fakulta;
import com.ciircat.studentsupport.entities.Program;
import com.ciircat.studentsupport.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public List<Program> getProgramsByFaculty(Fakulta fakulta){
        return this.programRepository.findProgramsByFakulta(fakulta);
    }
}
