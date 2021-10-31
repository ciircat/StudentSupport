package com.ciircat.studentsupport.restcontrollers;

import com.ciircat.studentsupport.commands.SideMenuState;
import com.ciircat.studentsupport.entities.Fakulta;
import com.ciircat.studentsupport.entities.Program;
import com.ciircat.studentsupport.helpers.DummyData;
import com.ciircat.studentsupport.service.FakultaService;
import com.ciircat.studentsupport.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/dummy-data")
    public DummyData getDummyData(@RequestBody SideMenuState sideMenuState){
        DummyData toReturn = new DummyData(sideMenuState);
        return toReturn;
    }
}
