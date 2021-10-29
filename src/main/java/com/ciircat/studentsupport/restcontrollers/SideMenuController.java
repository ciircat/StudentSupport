package com.ciircat.studentsupport.restcontrollers;

import com.ciircat.studentsupport.entities.Fakulta;
import com.ciircat.studentsupport.entities.Program;
import com.ciircat.studentsupport.service.FakultaService;
import com.ciircat.studentsupport.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SideMenuController {
    @Autowired
    private FakultaService fakultaService;
    @Autowired
    private ProgramService programService;

    @GetMapping("/programs/{nazevFakulty}")
    public List<String> getStudyProgramByFaculty(@PathVariable String nazevFakulty){
        Fakulta fakulta = this.fakultaService.getFakultaByNazevFakulty(nazevFakulty);
        List<Program> programs =  this.programService.getProgramsByFaculty(fakulta);
        List<String> toReturn = new ArrayList<>();
        for (Program p : programs){
            toReturn.add(p.getNazevProgramu());
        }
        return toReturn;
    }
}
