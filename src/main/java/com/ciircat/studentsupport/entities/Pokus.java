package com.ciircat.studentsupport.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "pokus")
public class Pokus extends BaseEntity{

    private String akademickyRok;
    private String semestr;
    private Date datumPokusu;
    private int tydenPokusu;
    private String znamka;
    private int ziskanoKreditu;
    private Date datumZapoctu;
    private String hodnoceniZapoctu;

    @ManyToOne
    @JoinColumn(name = "studium_id", referencedColumnName = "id")
    private Studium studium;

    @ManyToOne
    @JoinColumn(name = "predmet_id", referencedColumnName = "id")
    private Predmet predmet;
}
