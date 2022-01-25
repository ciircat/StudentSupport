package com.ciircat.studentsupport.restcontrollers;

import com.ciircat.studentsupport.entities.Predmet;
import com.ciircat.studentsupport.entities.Studium;
import com.ciircat.studentsupport.helpers.PredmetVTydnu;
import com.ciircat.studentsupport.helpers.StromPredmetu;
import com.ciircat.studentsupport.service.PokusService;
import com.ciircat.studentsupport.service.PredmetService;
import com.ciircat.studentsupport.service.StudiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class StromController {

    private StudiumService studiumService;
    private PokusService pokusService;
    private PredmetService predmetService;

    @Autowired
    public StromController(PredmetService predmetService, PokusService pokusService, StudiumService studiumService){
        this.studiumService = studiumService;
        this.pokusService = pokusService;
        this.predmetService = predmetService;
    }

    //@GetMapping("/strom")
    public void getStromStringy(){

        List<Studium> studiums = this.studiumService.findAllStudiumsByPassStatusAndAkademickyRok("Pass","2017");

        List<String> stringy = new ArrayList<>();
        for (Studium studium : studiums){
            String studiumString = "";
            int tyden = 1;
            for (String s : studium.getAbsolvovanePredmetyPoTydnech()){
                //pokud není v, bude tam jedno nebo více id
                if (!s.equals("v")){
                    //Pokud neobsahuje ",", tak vím, že je tam jen jedno id a mohu rovnou vyhledat předmět
                    if (!s.contains(",")){


                            Long id = Long.parseLong(s);
                            Predmet predmet = this.predmetService.findById(id);

                            if (predmet.getPocetKreditu()>4){
                                studiumString = studiumString + s;
                            }

                            tyden++;

                    }
                    // je tam čárka, takže musím projít char po charu a vyselektovat předměty
                    else {
                        String[] ids = s.split(",");
                        for (String string : ids){
                            Long id = Long.parseLong(string);
                            Predmet predmet = this.predmetService.findById(id);
                            if (predmet.getPocetKreditu()>4){
                                studiumString = studiumString + string;

                            }

                        }

                        tyden++;

                    }
                }else {
                    tyden++;
                }
            }

            stringy.add(studiumString);
        }

        Map<String, Integer> cetnost = new HashMap<>();
        for (String s : stringy){
            if (cetnost.containsKey(s)){
                int previous = cetnost.get(s);
                cetnost.remove(s);
                previous++;
                cetnost.put(s,previous);
            }else {
                cetnost.put(s,1);
            }
        }
        int kokot = 1;

    }

    @GetMapping("/strom")
    public void getStromSetySVolnem(){
        // najdu si všechna studia
        List<Studium> studiums = this.studiumService.findAllStudiumsByPassStatusAndAkademickyRok("Pass","2017");

        List<List<Set<String>>> stringy = new ArrayList<>();
        // projdu studium po studiu
        for (Studium studium : studiums){

            List<Set<String>> studiumSet = new ArrayList<>();
            int tyden = 1;
            for (String s : studium.getAbsolvovanePredmetyPoTydnech()){

                //Pokud neobsahuje ",", tak vím, že je tam jen jedno id a mohu rovnou vyhledat předmět
                if (!s.contains(",")){
                    Set<String> ablsolvovanyPredmet = new HashSet<>();

                    if (s.equals("v")){
                        if (tyden>1){
                            var predchoziTyden = studiumSet.get(tyden-2);
                            for (String ss : predchoziTyden){
                                ablsolvovanyPredmet.add(ss);
                            }
                            ablsolvovanyPredmet.add("v");
                            studiumSet.add(ablsolvovanyPredmet);
                            tyden++;

                        }else {
                            ablsolvovanyPredmet.add("v");
                            studiumSet.add(ablsolvovanyPredmet);
                            tyden++;

                        }
                    }else {
                        Long id = Long.parseLong(s);
                        Predmet predmet = this.predmetService.findById(id);

                        if (predmet.getPocetKreditu()>4){

                            if (tyden>1){
                                var predchoziTyden = studiumSet.get(tyden-2);
                                for (String ss : predchoziTyden){
                                    ablsolvovanyPredmet.add(ss);
                                }
                                ablsolvovanyPredmet.add(s);
                                studiumSet.add(ablsolvovanyPredmet);
                                tyden++;

                            }else {
                                ablsolvovanyPredmet.add(s);
                                studiumSet.add(ablsolvovanyPredmet);
                                tyden++;
                            }

                        }
                        //absolvoval předmět, který je za méně než minimum kreditů, takže je to jako by měl volno
                        else {
                            if (tyden>1){
                                var predchoziTyden = studiumSet.get(tyden-2);
                                for (String ss : predchoziTyden){
                                    ablsolvovanyPredmet.add(ss);
                                }
                                ablsolvovanyPredmet.add("v");
                                studiumSet.add(ablsolvovanyPredmet);
                                tyden++;

                            }else {
                                ablsolvovanyPredmet.add("v");
                                studiumSet.add(ablsolvovanyPredmet);
                                tyden++;
                            }

                        }


                    }


                }
                // je tam čárka, takže musím projít char po charu a vyselektovat předměty
                else {
                    String[] ids = s.split(",");
                    List<String> relevantniPredmety = new ArrayList<>();
                    for (String string : ids){
                        Long id = Long.parseLong(string);
                        Predmet predmet = this.predmetService.findById(id);
                        if (predmet.getPocetKreditu()>4){
                            relevantniPredmety.add(string);
                        }
                    }
                    if (relevantniPredmety.size()>0){
                        Set<String> absolvovanyPredmet = new HashSet<>();
                        if (tyden>1){
                            var predchoziTyden = studiumSet.get(tyden-2);
                            for (String ss : predchoziTyden){
                                absolvovanyPredmet.add(ss);
                            }
                            for (String str : relevantniPredmety){
                                absolvovanyPredmet.add(str);
                            }
                            studiumSet.add(absolvovanyPredmet);
                            tyden++;

                        }else {
                            for (String str : relevantniPredmety){
                                absolvovanyPredmet.add(str);
                            }
                            studiumSet.add(absolvovanyPredmet);
                            tyden++;

                        }

                    }else {
                        Set<String> absolvovanyPredmet = new HashSet<>();
                        if (tyden>1){
                            var predchoziTyden = studiumSet.get(tyden-2);
                            for (String ss : predchoziTyden){
                                absolvovanyPredmet.add(ss);
                            }
                            absolvovanyPredmet.add("v");
                            studiumSet.add(absolvovanyPredmet);
                            tyden++;

                        }else {
                            absolvovanyPredmet.add("v");
                            studiumSet.add(absolvovanyPredmet);
                            tyden++;

                        }

                    }

                }

            }

            stringy.add(studiumSet);
        }
       /* List<List<Set<String>>> testStringy = new ArrayList<>();
        List<Set<String>> testStudium1 = new ArrayList<>();
        String s1 = "v";
        Set<String> k1 = new HashSet<>();
        k1.add(s1);
        testStudium1.add(k1);
        String s2 = "v";
        Set<String> k2 = new HashSet<>();
        k2.add(s1);
        k2.add(s2);
        testStudium1.add(k2);
        String s3 = "992";
        Set<String> k3 = new HashSet<>();
        k3.add(s1);
        k3.add(s2);
        k3.add(s3);
        testStudium1.add(k3);
        String s4 = "666";
        Set<String> k4 = new HashSet<>();
        k4.add(s1);
        k4.add(s2);
        k4.add(s3);
        k4.add(s4);
        testStudium1.add(k4);
        String s5 = "69";
        Set<String> k5 = new HashSet<>();
        k5.add(s1);
        k5.add(s2);
        k5.add(s3);
        k5.add(s4);
        k5.add(s5);
        testStudium1.add(k5);
        testStringy.add(testStudium1);

        List<Set<String>> testStudium2 = new ArrayList<>();
        String s21 = "v";
        Set<String> k21 = new HashSet<>();
        k21.add(s21);
        testStudium2.add(k21);
        String s22 = "v";
        Set<String> k22 = new HashSet<>();
        k22.add(s21);
        k22.add(s22);
        testStudium2.add(k22);
        String s23 = "992";
        Set<String> k23 = new HashSet<>();
        k23.add(s21);
        k23.add(s22);
        k23.add(s23);
        testStudium2.add(k23);
        String s24 = "666";
        Set<String> k24 = new HashSet<>();
        k24.add(s21);
        k24.add(s22);
        k24.add(s23);
        k24.add(s24);
        testStudium2.add(k24);
        String s25 = "69";
        Set<String> k25 = new HashSet<>();
        k25.add(s21);
        k25.add(s22);
        k25.add(s23);
        k25.add(s24);
        k25.add(s25);
        testStudium2.add(k25);
        testStringy.add(testStudium2);


*/

        Map<List<Set<String>>, Integer> cetnost = new HashMap<>();
        boolean firstPass = true;

        for (List<Set<String>> s : stringy){
            if (firstPass){
                cetnost.put(s,1);
                firstPass = false;
            }else {
                boolean rovnost = true;
                for (var xx : cetnost.keySet()){
                    for (int i = 0; i<5; i++){
                        if (!s.get(i).equals(xx.get(i))){
                            rovnost = false;
                            break;
                        }else {
                            continue;
                        }
                    }

                }
                if (rovnost){
                    int previous = cetnost.get(s);
                    cetnost.remove(s);
                    previous++;
                    cetnost.put(s,previous);
                }else {
                    cetnost.put(s,1);
                }

            }

        }

        int stop = 666;
    }

    //@GetMapping("/strom")
    public void getStromSetyBezVolna(){
        // najdu si všechna studia
        List<Studium> studiums = this.studiumService.findAllStudiumsByPassStatusAndAkademickyRok("Pass","2017");

        List<List<Set<String>>> stringy = new ArrayList<>();
        // projdu studium po studiu
        for (Studium studium : studiums){

            List<Set<String>> studiumSet = new ArrayList<>();
            int pridano = 0;
            for (String s : studium.getAbsolvovanePredmetyPoTydnech()){

                //Pokud neobsahuje ",", tak vím, že je tam jen jedno id a mohu rovnou vyhledat předmět
                if (!s.contains(",")){
                    Set<String> ablsolvovanyPredmet = new HashSet<>();

                    if (s.equals("v")){
                    }else {
                        Long id = Long.parseLong(s);
                        Predmet predmet = this.predmetService.findById(id);

                        if (predmet.getPocetKreditu()>4){

                            if (pridano>0){
                                var predchoziTyden = studiumSet.get(pridano-1);
                                for (String ss : predchoziTyden){
                                    ablsolvovanyPredmet.add(ss);
                                }
                                ablsolvovanyPredmet.add(s);
                                studiumSet.add(ablsolvovanyPredmet);
                                pridano++;

                            }else {
                                ablsolvovanyPredmet.add(s);
                                studiumSet.add(ablsolvovanyPredmet);
                                pridano++;
                            }

                        }
                        //absolvoval předmět, který je za méně než minimum kreditů, takže je to jako by měl volno
                        else {

                        }


                    }


                }
                // je tam čárka, takže musím projít char po charu a vyselektovat předměty
                else {
                    String[] ids = s.split(",");
                    List<String> relevantniPredmety = new ArrayList<>();
                    for (String string : ids){
                        Long id = Long.parseLong(string);
                        Predmet predmet = this.predmetService.findById(id);
                        if (predmet.getPocetKreditu()>4){
                            relevantniPredmety.add(string);
                        }
                    }
                    if (relevantniPredmety.size()>0){
                        Set<String> absolvovanyPredmet = new HashSet<>();
                        if (pridano>0){
                            var predchoziTyden = studiumSet.get(pridano-1);
                            for (String ss : predchoziTyden){
                                absolvovanyPredmet.add(ss);
                            }
                            for (String str : relevantniPredmety){
                                absolvovanyPredmet.add(str);
                            }
                            studiumSet.add(absolvovanyPredmet);
                            pridano++;

                        }else {
                            for (String str : relevantniPredmety){
                                absolvovanyPredmet.add(str);
                            }
                            studiumSet.add(absolvovanyPredmet);
                            pridano++;

                        }

                    }else {

                    }

                }

            }

            stringy.add(studiumSet);
        }

        Map<List<Set<String>>, Integer> cetnost = new HashMap<>();
        boolean firstPass = true;

        for (List<Set<String>> s : stringy){
            if (firstPass){
                cetnost.put(s,1);
                firstPass = false;
            }else {
                boolean rovnost = true;
                for (var xx : cetnost.keySet()){
                    if (xx.size() != s.size()){
                        continue;
                    }else {
                        for (int i = 0; i<s.size(); i++){
                            if (!s.get(i).equals(xx.get(i))){
                                rovnost = false;
                                break;
                            }else {
                                continue;
                            }
                        }

                    }


                }
                if (rovnost){
                    int previous = cetnost.get(s);
                    cetnost.remove(s);
                    previous++;
                    cetnost.put(s,previous);
                }else {
                    cetnost.put(s,1);
                }

            }

        }

        int stop = 666;
    }
}
