package com.ciircat.studentsupport.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class DataLineGraph{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazevUniverzity;
    private String nazevFakulty;
    private String nazevProgramu;
    private String kodProgramu;
    private String nazevOboruSpecializace;
    private String kodOboruSpecializace;
    private String akademickyRok;
    @ElementCollection
    private List<Integer> averagePassData;
    @ElementCollection
    private List<Integer> averageFailData;



    /*@OneToMany(cascade = CascadeType.ALL ,mappedBy = "dataLineGraph")
    private List<WeekAveragePass> passAverages;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "dataLineGraph")
    private List<WeekAverageFail> failAverages;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getAveragePassData() {
        return averagePassData;
    }

    public void setAveragePassData(List<Integer> averagePassData) {
        this.averagePassData = averagePassData;
    }

    public List<Integer> getAverageFailData() {
        return averageFailData;
    }

    public void setAverageFailData(List<Integer> averageFailData) {
        this.averageFailData = averageFailData;
    }

    public String getNazevUniverzity() {
        return nazevUniverzity;
    }

    public void setNazevUniverzity(String nazevUniverzity) {
        this.nazevUniverzity = nazevUniverzity;
    }

    public String getNazevFakulty() {
        return nazevFakulty;
    }

    public void setNazevFakulty(String nazevFakulty) {
        this.nazevFakulty = nazevFakulty;
    }

    public String getNazevProgramu() {
        return nazevProgramu;
    }

    public void setNazevProgramu(String nazevProgramu) {
        this.nazevProgramu = nazevProgramu;
    }

    public String getKodProgramu() {
        return kodProgramu;
    }

    public void setKodProgramu(String kodProgramu) {
        this.kodProgramu = kodProgramu;
    }

    public String getNazevOboruSpecializace() {
        return nazevOboruSpecializace;
    }

    public void setNazevOboruSpecializace(String nazevOboruSpecializace) {
        this.nazevOboruSpecializace = nazevOboruSpecializace;
    }

    public String getKodOboruSpecializace() {
        return kodOboruSpecializace;
    }

    public void setKodOboruSpecializace(String kodOboruSpecializace) {
        this.kodOboruSpecializace = kodOboruSpecializace;
    }

    public String getAkademickyRok() {
        return akademickyRok;
    }

    public void setAkademickyRok(String akademickyRok) {
        this.akademickyRok = akademickyRok;
    }
/*
    public List<WeekAveragePass> getPassAverages() {
        return passAverages;
    }

    public void setPassAverages(List<WeekAveragePass> passAverages) {
        this.passAverages = passAverages;
    }

    public List<WeekAverageFail> getFailAverages() {
        return failAverages;
    }

    public void setFailAverages(List<WeekAverageFail> failAverages) {
        this.failAverages = failAverages;
    }*/
}
