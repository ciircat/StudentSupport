package com.ciircat.studentsupport.entities;

import com.ciircat.studentsupport.enums.Semestr;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "predmet")
public class Predmet extends BaseEntity{
    private String kodPracoviste;
    private String kodPredmetu;
    private String kombinovanyKod;
    private String nazevPredmetu;
    private int pocetKreditu;
    private Boolean vyucovanoVLetnimSemestru;
    private Boolean vyucovanoVZimnimSemestru;
    @OneToMany(mappedBy = "predmet")
    private List<Pokus> pokusy;

    @ManyToMany(mappedBy = "predmetyProgramu")
    private Set<Program> programy;

    @ManyToMany(mappedBy = "predmetyOboruSpecializace")
    private Set<OborSpecializace> oborySpecializace;
}
