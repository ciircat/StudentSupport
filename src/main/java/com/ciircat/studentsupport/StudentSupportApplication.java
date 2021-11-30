package com.ciircat.studentsupport;

import com.ciircat.studentsupport.entities.DataBarGraph;
import com.ciircat.studentsupport.entities.Studium;
import com.ciircat.studentsupport.service.DataBarGraphService;
import com.ciircat.studentsupport.service.PokusService;
import com.ciircat.studentsupport.service.StudiumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StudentSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSupportApplication.class, args);
    }

   /* @Bean
    CommandLineRunner run(PokusService pokusService, StudiumService studiumService, DataBarGraphService dataBarGraphService){
        return args -> {
            var x = pokusService.findAllPokuses();
            List<Studium> studia = studiumService.findAllStudiumsInGivenYear("2017");
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



            }

        };
    }*/

}
