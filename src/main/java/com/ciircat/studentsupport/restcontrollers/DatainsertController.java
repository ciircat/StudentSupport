package com.ciircat.studentsupport.restcontrollers;

import com.ciircat.studentsupport.entities.*;
import com.ciircat.studentsupport.service.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

// přidání univerzity, programu, oboru specializace, studentů a předmětů

@RestController
public class DatainsertController {

    private UniverzitaServiceImpl univerzitaService;
    private FakultaService fakultaService;
    private ProgramService programService;
    private PredmetService predmetService;
    private StudentService studentService;
    private OborSpecializaceService oborSpecializaceService;
    private Set<Student> savedStudents = new HashSet<>();
    private Set<Predmet> savedPredmets = new HashSet<>();
    private Univerzita savedUniverzita;
    private Fakulta savedFakulta;
    private OborSpecializace savedOborSpecializace;
    private Program savedProgram;
    private StudiumService studiumService;
    private PokusService pokusService;
    private DataLineGraphService dataLineGraphService;
    private DataBarGraphService dataBarGraphService;

     public DatainsertController(DataBarGraphService dataBarGraphService,DataLineGraphService dataLineGraphService, PokusService pokusService, StudiumService studiumService,UniverzitaServiceImpl univerzitaService, FakultaService fakultaService, ProgramService programService, PredmetService predmetService, StudentService studentService, OborSpecializaceService oborSpecializaceService){
         this.dataBarGraphService = dataBarGraphService;
         this.dataLineGraphService = dataLineGraphService;
         this.studiumService = studiumService;
         this.univerzitaService = univerzitaService;
         this.fakultaService = fakultaService;
         this.programService = programService;
         this.predmetService = predmetService;
         this.studentService = studentService;
         this.oborSpecializaceService = oborSpecializaceService;
         this.pokusService = pokusService;
     }


    //@GetMapping("/migrate")
    public void migrateDataFromExcel(){
         Univerzita vut = new Univerzita();
        vut.setNazevUniverzity("Vysoké učení technické");
        vut.setUniverzitniIdentifikacniKod("vut");
        this.savedUniverzita = this.univerzitaService.save(vut);
        var id = savedUniverzita.getId();
        Fakulta fsi = new Fakulta();
        fsi.setNazevFakulty("Fakulta strojního inženýrství");
        fsi.setUniverzita(savedUniverzita);
        fsi.setZkratka("fsi");
        this.savedFakulta = this.fakultaService.saveFakulta(fsi);

        Program program = new Program();
        program.setFakulta(savedFakulta);
        program.setKodProgramu("B");
        program.setNazevProgramu("B");

        OborSpecializace oborSpecializace = new OborSpecializace();
        oborSpecializace.setKodOboruSpecializace("2341R006");
        List<OborSpecializace> oborySpecializace = new ArrayList<>();
        oborySpecializace.add(oborSpecializace);

        program.setOborySpecializace(oborySpecializace);
        oborSpecializace.setProgram(program);
        this.savedProgram = this.programService.saveProgram(program);
        this.savedOborSpecializace = this.oborSpecializaceService.saveOborSpecializace(oborSpecializace);




        File file = new File("C:\\Users\\filip\\Desktop\\data_vut_zkracene2017.xlsx");
        FileInputStream fileInputStream;
        Set<Predmet> predmety = new HashSet<>();
        Set<Student> studenti = new HashSet<>();


        try {
             fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            int numberOfRuns = 0;
            while (rowIterator.hasNext()){
                numberOfRuns++;
                Row row = rowIterator.next();
                if (numberOfRuns > 1){
                    Student student = new Student();
                    student.setStudentovoId(Integer.toString((int)row.getCell(1).getNumericCellValue()));
                    student.setPohlavi(row.getCell(19).getStringCellValue());
                    studenti.add(student);



                    Predmet predmet = new Predmet();
                    predmet.setNazevPredmetu(row.getCell(4).getStringCellValue());
                    predmet.setKodPredmetu(row.getCell(5).getStringCellValue());
                    predmet.setTypUkonceni(row.getCell(6).getStringCellValue());
                    predmet.setPocetKreditu((int)row.getCell(14).getNumericCellValue());
                    Set<Program> programy = new HashSet<>();
                    programy.add(savedProgram);
                    predmet.setProgramy(programy);
                    predmety.add(predmet);







                }



            }
            int kokot = 666;
            for (Student s : studenti){
                Student savedStudent = this.studentService.saveStudent(s);
                this.savedStudents.add(savedStudent);
            }


            fileInputStream.close();
            for (Predmet p : predmety){
                Predmet savedPredmet = this.predmetService.savePredmet(p);
                this.savedPredmets.add(savedPredmet);
            }




        }catch (Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();

        }

        try {
            fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            List<Studium> studia = new ArrayList<>();
            List<Pokus> pokusy = new ArrayList<>();
            Set<Studium> studiaSet = new HashSet<>();
            int numberOfRuns = 0;
            while (rowIterator.hasNext()){
                numberOfRuns++;
                Row row = rowIterator.next();
                if (numberOfRuns > 1){

                    // podívám se, jestli dané studium již existuje a pokud ne tak jej vytvořím
                    // studium se vyhledává pomocí studenta a oboru specializace - rozumný předpoklad že bude unikátní

                    // najdu si studenta podle id, určitě nebude null protože jsem je už podle dokumentu přidal
                    Student s = this.studentService.findStudentByStudentovoId(Integer.toString((int)row.getCell(1).getNumericCellValue()));;
                    // podívám se, jestli již má daný student studium
                    Studium studium = this.studiumService.findStudiumByStudentAndOborSpecializace(s, this.savedOborSpecializace);
                    //pokud ještě neexistuje, tak jej vytvořím
                    if (studium == null){
                        Studium noveStudium = new Studium();
                        noveStudium.setOborSpecializace(oborSpecializace);
                        noveStudium.setFormaStudia("prezencni");
                        noveStudium.setStudent(s);
                        noveStudium.setProgram(program);
                        noveStudium.setRokMaturitniZkousky(Integer.toString((int)row.getCell(30).getNumericCellValue()));
                        noveStudium.setVysledekPrvnihoRokuStudia(row.getCell(34).getStringCellValue());
                        Pokus pokus = new Pokus();
                        pokus.setStudium(noveStudium);
                        pokus.setAkademickyRok(Integer.toString((int)row.getCell(2).getNumericCellValue()));
                        pokus.setTydenPokusu((int)row.getCell(9).getNumericCellValue());
                        pokus.setSemestr(row.getCell(3).getStringCellValue());
                        String znamka;
                        try {
                            znamka = row.getCell(11).getStringCellValue();
                        }catch (NullPointerException exception){
                            znamka = "NA";
                        }

                        pokus.setZnamka(znamka);
                        if (znamka.equals("A") || znamka.equals("B") || znamka.equals("C") || znamka.equals("D") || znamka.equals("E")){
                            pokus.setPredmetSplnen(true);
                        }else {
                            pokus.setPredmetSplnen(false);
                        }
                        pokus.setPredmet(
                                this.predmetService.findPredmetByNazevPredmetu(row.getCell(4).getStringCellValue())
                        );
                        pokus.setCisloPokusu((int)row.getCell(10).getNumericCellValue());
                        if (row.getCell(12).getStringCellValue().equals("A")){
                            pokus.setJdeOKonecnouZnamku(true);
                        }else {
                            pokus.setJdeOKonecnouZnamku(false);
                        }


                        noveStudium.addPokus(pokus);
                        studia.add(noveStudium);
                        pokusy.add(pokus);
                        this.studiumService.saveStudium(noveStudium);
                        this.pokusService.savePokus(pokus);


                    }else {
                        Pokus pokus = new Pokus();
                        pokus.setStudium(studium);
                        pokus.setAkademickyRok(Integer.toString((int)row.getCell(2).getNumericCellValue()));
                        pokus.setTydenPokusu((int)row.getCell(9).getNumericCellValue());
                        pokus.setSemestr(row.getCell(3).getStringCellValue());
                        String znamka;
                        try {
                            znamka = row.getCell(11).getStringCellValue();
                        }catch (NullPointerException exception){
                            znamka = "NA";
                        }

                        pokus.setZnamka(znamka);
                        if (znamka.equals("A") || znamka.equals("B") || znamka.equals("C") || znamka.equals("D") || znamka.equals("E")){
                            pokus.setPredmetSplnen(true);
                        }else {
                            pokus.setPredmetSplnen(false);
                        }
                        pokus.setPredmet(
                                this.predmetService.findPredmetByNazevPredmetu(row.getCell(4).getStringCellValue())
                        );
                        pokus.setCisloPokusu((int)row.getCell(10).getNumericCellValue());
                        if (row.getCell(12).getStringCellValue().equals("A")){
                            pokus.setJdeOKonecnouZnamku(true);
                        }else {
                            pokus.setJdeOKonecnouZnamku(false);
                        }

                        studium.addPokus(pokus);
                        pokusy.add(pokus);
                        this.studiumService.saveStudium(studium);
                        this.pokusService.savePokus(pokus);
                    }

                }

            }
            int kokot = 666;



            fileInputStream.close();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();

        }
        int dement = 666;







    }

    //@GetMapping("/migrate")
    /*public void createDataStructures(){
         List<Pokus> pokusyVsechStudiiKtereProslyDoDalsihoRoku = this.pokusService.findAllPokusesByYearAndPassStatus("2017", "Pass");
         List<Pokus> pokusyVsechStudiiKtereNepryslyDoDalsihoRoku = this.pokusService.findAllPokusesByYearAndPassStatus("2017","Fail");
        int[] dosazeneKredityPoTydnechPass = new int[53];
        int[] dosazeneKredityPoTydnechFail = new int[53];
        int[] kumulovaneDosazeneKredityPoTydnechPass = new int[53];
        int[] kumulovaneDosazeneKredityPoTydnechFail = new int[53];
        int[] kumulovaneDosazeneKredityPoTydnechPrumerPass = new int[53];
        int[] kumulovaneDosazeneKredityPoTydnechPrumerFail = new int[53];
        int celkemKredituPass = 0;
        int celkemKredituFail = 0;
        List<Studium> passedStudiumsIn2019 = this.studiumService.findAllStudiumsByPassStatusAndAkademickyRok("Pass","2017");
        List<Studium> failedStudiumsIn2019 = this.studiumService.findAllStudiumsByPassStatusAndAkademickyRok("Fail","2017");;
        List<Studium> allStudiumsIn2019 = this.studiumService.findAllStudiumsInGivenYear("2017");
        for (Pokus p : pokusyVsechStudiiKtereProslyDoDalsihoRoku){
            if (p.isPredmetSplnen() && p.isJdeOKonecnouZnamku()){
                if ((p.getTydenPokusu() - 1) > 52){
                    p.setTydenPokusu(53);
                }
                dosazeneKredityPoTydnechPass[p.getTydenPokusu() - 1] += p.getPredmet().getPocetKreditu();
                celkemKredituPass+=p.getPredmet().getPocetKreditu();

            }
        }

        for (Pokus p : pokusyVsechStudiiKtereNepryslyDoDalsihoRoku){
            if (p.isPredmetSplnen() && p.isJdeOKonecnouZnamku()){
                if ((p.getTydenPokusu() - 1) > 52){
                    p.setTydenPokusu(53);
                }

                dosazeneKredityPoTydnechFail[p.getTydenPokusu() - 1] += p.getPredmet().getPocetKreditu();
                celkemKredituFail+=p.getPredmet().getPocetKreditu();

            }
        }

        int index = 0;
        for (int x : dosazeneKredityPoTydnechPass){
            if (index == 0){
                kumulovaneDosazeneKredityPoTydnechPass[index] = x;


            }else {
                kumulovaneDosazeneKredityPoTydnechPass[index] = x + kumulovaneDosazeneKredityPoTydnechPass[index -1];

            }
            index++;

        }

        index = 0;
        for (int x : dosazeneKredityPoTydnechFail){
            if (index == 0){
                kumulovaneDosazeneKredityPoTydnechFail[index] = x;


            }else {
                kumulovaneDosazeneKredityPoTydnechFail[index] = x + kumulovaneDosazeneKredityPoTydnechFail[index -1];

            }
            index++;

        }



        index = 0;
        for (int i : kumulovaneDosazeneKredityPoTydnechPass){
            kumulovaneDosazeneKredityPoTydnechPrumerPass[index] = i/passedStudiumsIn2019.size();
            index++;
        }
        index = 0;
        for (int i : kumulovaneDosazeneKredityPoTydnechFail){
            kumulovaneDosazeneKredityPoTydnechPrumerFail[index] = i/failedStudiumsIn2019.size();
            index++;
        }

        DataLineGraph dataLineGraph = new DataLineGraph();
        dataLineGraph.setAkademickyRok("2017");
        dataLineGraph.setNazevUniverzity("Vysoké učení technické");
        dataLineGraph.setNazevFakulty("Fakulta strojního inženýrství");
        dataLineGraph.setNazevProgramu("B");
        dataLineGraph.setKodProgramu("B");
        dataLineGraph.setKodOboruSpecializace("2341R006");
        List<Integer> kokot = new ArrayList<>();
        for (int x : kumulovaneDosazeneKredityPoTydnechPrumerFail){
            kokot.add(x);
        }

        List<Integer> kokot2 = new ArrayList<>();
        for (int x : kumulovaneDosazeneKredityPoTydnechPrumerPass){
            kokot2.add(x);
        }
        dataLineGraph.setAverageFailData(kokot);
        dataLineGraph.setAveragePassData(kokot2);
        this.dataLineGraphService.saveDataLineGrap(dataLineGraph);

         int dement = 69;
    }*/
    //@GetMapping("/migrate")
    public void createKumulovaneKredity(){
         int[] dosazeneKredityPoTydnech;
         int[] kumulovaneDosazeneKredityPoTydnech;
        var x = pokusService.findAllPokuses();
          List<Studium> vsechnaStudiaDanehoRoku = this.studiumService.findAllStudiumsInGivenYear("2017");
        //List<Studium> vsechnaStudiaDanehoRoku = this.studiumService.findAllStudiumsByPassStatusAndAkademickyRok("Pass", "2017");
         for (Studium studium : vsechnaStudiaDanehoRoku){
             if (studium.getStudent().getStudentovoId().equals("243534")){
                 int dement = 7;
             }
             List<Pokus> vsechnyPokusyDanehoStudia = studium.getPokusy();
             dosazeneKredityPoTydnech =  new int[53];
             kumulovaneDosazeneKredityPoTydnech = new int[53];
             for (Pokus p : vsechnyPokusyDanehoStudia){

                 if (p.isPredmetSplnen() && p.isJdeOKonecnouZnamku()){
                     dosazeneKredityPoTydnech[p.getTydenPokusu()] += p.getPredmet().getPocetKreditu();
                 }
             }
             int index = 0;
             for (int i : dosazeneKredityPoTydnech){
                 if (index == 0){
                     kumulovaneDosazeneKredityPoTydnech[index] = i;
                 }else {
                     kumulovaneDosazeneKredityPoTydnech[index] = kumulovaneDosazeneKredityPoTydnech[index - 1] + i;
                 }
                 index++;
             }

             List<Integer> studentoviKumulovaneKredity = new ArrayList<>();
             for (int i : kumulovaneDosazeneKredityPoTydnech){
                 studentoviKumulovaneKredity.add(i);
             }
             int dement = 666;
             studium.setKumulovaneKredityPoTydnech(studentoviKumulovaneKredity);
             this.studiumService.saveStudium(studium);

         }
         int pica = 666;

    }
    //@GetMapping("/migrate")
    public void createBarGraph(){
        var x = pokusService.findAllPokuses();
        List<Studium> studia = this.studiumService.findAllStudiumsInGivenYear("2017");
        List<int[]> d = new ArrayList<>();
        for (int tyden = 0; tyden < 53; tyden++){
            List<List<Studium>> a = new ArrayList<>();
            for (int kredit = 0; kredit <72; kredit++){
                List<Studium> sa = new ArrayList<>();
                for (Studium s : studia){

                    if (s.getKumulovaneKredityPoTydnech().get(tyden)== kredit){
                        sa.add(s);
                    }
                }
                a.add(sa);
            }
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < 72; i++){
                double thatPassed = 0;
                for (Studium s : a.get(i)){
                    if (s.getVysledekPrvnihoRokuStudia().equals("Pass")){
                        thatPassed++;
                    }
                }
                if (a.get(i).size() == 0){
                    b.add(i,-1);
                }else {
                    b.add(i,(int)(100*((thatPassed)/a.get(i).size())));
                }

            }

            DataBarGraph dataBarGraph = new DataBarGraph();
            dataBarGraph.setNazevUniverzity("Vysoké učení technické");
            dataBarGraph.setNazevfakulty("Fakulta strojního inženýrství");
            dataBarGraph.setNazevProgramu("B");
            dataBarGraph.setKodOboruSpecializace("2341R006");
            dataBarGraph.setAkademickyRok("2017");
            dataBarGraph.setWeek(tyden);
            dataBarGraph.setPravdepodobnostPass(b);
            this.dataBarGraphService.saveDataBarGraph(dataBarGraph);





        }

        int pica = 666;





    }

    //@GetMapping("/migrate")
    public void demeter(){
        var x = this.pokusService.findAllPokuses();

        for (Pokus p : x){
            if (p.getPredmet().getTypUkonceni().equals("zápočet")){
                if (p.getZnamka().equals("S")){
                    p.setPredmetSplnen(true);
                    this.pokusService.savePokus(p);
                }

            }
        }
    }
    //@GetMapping("/migrate")
    public void pitkus(){
        var y = this.pokusService.findAllPokusesInGivenYear("2017");
        var x = this.studiumService.getAllStudiums();
        for (Studium s : x){
            if (s.getKumulovaneKredityPoTydnech().get(52)==17){
                int kkk = 1;
            }
        }
    }
}

