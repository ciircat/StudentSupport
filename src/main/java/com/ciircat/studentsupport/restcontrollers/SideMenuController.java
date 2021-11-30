package com.ciircat.studentsupport.restcontrollers;

import com.ciircat.studentsupport.commands.SideMenuState;
import com.ciircat.studentsupport.entities.*;
import com.ciircat.studentsupport.helpers.DummyData;
import com.ciircat.studentsupport.helpers.PredmetData;
import com.ciircat.studentsupport.service.*;
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
    @Autowired
    private DataLineGraphService dataLineGraphService;
    @Autowired
    private StudiumService studiumService;
    @Autowired
    private PokusService pokusService;
    @Autowired
    private PredmetService predmetService;
    @Autowired
    private DataBarGraphService dataBarGraphService;
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

    @PostMapping("/line-graph-data")
    public DummyData getLineGraphData(@RequestBody SideMenuState sideMenuState){
        String faculty = sideMenuState.getFaculty();
        String studyProgram = sideMenuState.getStudyProgram();
        String academicYear = sideMenuState.getAcademicYear();
        DataLineGraph dataLineGraph = this.dataLineGraphService.findDataLineGraphByNazevFakultyAndNazevProgramuAndAkademickyRok(faculty,studyProgram,academicYear);

        DummyData toReturn = new DummyData();
        toReturn.setPassStudentsSummer(100);
        toReturn.setFailStudentsSummer(1);
        toReturn.setPassStudentsWinter(99);
        toReturn.setFailStudentsWinter(0);
        toReturn.setFailStudentsTotal(1);
        toReturn.setInterventionCreditIntervalStart(10);
        toReturn.setInterventionCreditIntervalStop(50);
        toReturn.setDataFailed(dataLineGraph.getAverageFailData());
        toReturn.setDataPassed(dataLineGraph.getAveragePassData());
        return toReturn;
    }

    @PostMapping("bar-graph-data")
    public List<Integer> getBarDataGraph(@RequestBody SideMenuState sideMenuState){
        String faculty = sideMenuState.getFaculty();
        String studyProgram = sideMenuState.getStudyProgram();
        String academicYear = sideMenuState.getAcademicYear();
        String value = sideMenuState.getValue();
        var toReturn = this.dataBarGraphService.getDataBarGraphByNazevfakultyAndNazevProgramuAndAkademickyRok(faculty,studyProgram,academicYear,value);
        return toReturn.getPravdepodobnostPass();

    }

    @PostMapping("courses-overview-data")
    public List<PredmetData> getCoursesOverviewData(@RequestBody SideMenuState sideMenuState){
        String faculty = sideMenuState.getFaculty();
        String studyProgram = sideMenuState.getStudyProgram();
        String academicYear = sideMenuState.getAcademicYear();
        List<Predmet> predmety = new ArrayList<>();

        //List<Pokus> pokusy = this.pokusService.findAllPokusesByNazevFakultyAndNazevProgramuAndAkademickyRok(faculty,studyProgram,academicYear);
        predmety = this.predmetService.kokot(faculty,studyProgram,academicYear);
        List<PredmetData> data = new ArrayList<>();


        for (Predmet p : predmety){
            PredmetData pd = new PredmetData();
            double pass = 0;
            double fail = 0;
            pd.setNazev(p.getNazevPredmetu());
            for (Pokus pokus : p.getPokusy()){

                if (pokus.isPredmetSplnen() && pokus.isJdeOKonecnouZnamku()){
                    pass++;
                }else {
                    fail++;
                }
                if (pokus.isJdeOKonecnouZnamku()){
                    if (pokus.getCisloPokusu()==0){
                        pd.incrementPosledniUspesnyPokus0();
                    }else if (pokus.getCisloPokusu()==1){
                        pd.incrementPosledniUspesnyPokus1();
                    }else if (pokus.getCisloPokusu()==2){
                        pd.incrementPosledniUspesnyPokus2();
                    }else {
                        pd.incrementPosledniUspesnyPokus3();
                    }

                    if (pokus.getZnamka().equals("A")){
                        pd.pocetA++;
                    }else if (pokus.getZnamka().equals("B")){
                        pd.pocetB++;
                    }else if (pokus.getZnamka().equals("C")){
                        pd.pocetC++;
                    }else if (pokus.getZnamka().equals("D")){
                        pd.pocetD++;
                    }else if (pokus.getZnamka().equals("E")){
                        pd.pocetE++;
                    }else {
                        pd.pocetF++;
                    }
                }
            }
            pd.setPassFailRatio((int)(100*(pass/(pass+fail))));
            pd.setProcentoA((int)(100*(pd.pocetA/(pd.pocetA + pd.pocetB + pd.pocetE + pd.pocetC + pd.pocetD + pd.pocetF))));
            pd.setProcentoB((int)(100*(pd.pocetB/(pd.pocetA + pd.pocetB + pd.pocetE + pd.pocetC + pd.pocetD + pd.pocetF))));
            pd.setProcentoD((int)(100*(pd.pocetD/(pd.pocetA + pd.pocetB + pd.pocetE + pd.pocetC + pd.pocetD + pd.pocetF))));
            pd.setProcentoC((int)(100*(pd.pocetC/(pd.pocetA + pd.pocetB + pd.pocetE + pd.pocetC + pd.pocetD + pd.pocetF))));
            pd.setProcentoE((int)(100*(pd.pocetE/(pd.pocetA + pd.pocetB + pd.pocetE + pd.pocetC + pd.pocetD + pd.pocetF))));
            pd.setProcentoF((int)(100*(pd.pocetF/(pd.pocetA + pd.pocetB + pd.pocetE + pd.pocetC + pd.pocetD + pd.pocetF))));
            data.add(pd);
        }

        return data;


    }
}
