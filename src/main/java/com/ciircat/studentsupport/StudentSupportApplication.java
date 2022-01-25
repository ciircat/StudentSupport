package com.ciircat.studentsupport;

import com.ciircat.studentsupport.entities.DataBarGraph;
import com.ciircat.studentsupport.entities.Pokus;
import com.ciircat.studentsupport.entities.Predmet;
import com.ciircat.studentsupport.entities.Studium;
import com.ciircat.studentsupport.service.DataBarGraphService;
import com.ciircat.studentsupport.service.PokusService;
import com.ciircat.studentsupport.service.PredmetService;
import com.ciircat.studentsupport.service.StudiumService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;


@SpringBootApplication
public class StudentSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSupportApplication.class, args);
    }

   /* @Bean
    CommandLineRunner run(PredmetService predmetService, PokusService pokusService, StudiumService studiumService, DataBarGraphService dataBarGraphService){
        return args -> {



        };
    }*/

}
