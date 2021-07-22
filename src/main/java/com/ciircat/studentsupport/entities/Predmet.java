package com.ciircat.studentsupport.entities;

import com.ciircat.studentsupport.enums.Semestr;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "course")
public class Predmet extends BaseEntity{
    private String kodPracoviste;
    private String kodPredmetu;
    private String kombinovanyKod;
    private String nazevPredmetu;
    private int pocetKreditu;
    private Boolean vyucovanoVLetnimSemestru;
    private Boolean vyucovanoVZimnimSemestru;
}
