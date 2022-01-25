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
    private List<Integer> averagePassDataAll;
    @ElementCollection
    private List<Integer> averageFailDataAll;
    @ElementCollection
    private List<Integer> averagePassDataPrezencni;
    @ElementCollection
    private List<Integer> averageFailDataPrezencni;
    @ElementCollection
    private List<Integer> averagePassDataKombinovane;
    @ElementCollection
    private List<Integer> averageFailDataKombinovane;


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

    public List<Integer> getAveragePassDataKombinovane() {
        return averagePassDataKombinovane;
    }

    public void setAveragePassDataKombinovane(List<Integer> averagePassDataKombinovane) {
        this.averagePassDataKombinovane = averagePassDataKombinovane;
    }

    public List<Integer> getAverageFailDataKombinovane() {
        return averageFailDataKombinovane;
    }

    public void setAverageFailDataKombinovane(List<Integer> averageFailDataKombinovane) {
        this.averageFailDataKombinovane = averageFailDataKombinovane;
    }

    public List<Integer> getAveragePassDataAll() {
        return averagePassDataAll;
    }

    public void setAveragePassDataAll(List<Integer> averagePassDataAll) {
        this.averagePassDataAll = averagePassDataAll;
    }

    public List<Integer> getAverageFailDataAll() {
        return averageFailDataAll;
    }

    public void setAverageFailDataAll(List<Integer> averageFailDataAll) {
        this.averageFailDataAll = averageFailDataAll;
    }

    public List<Integer> getAveragePassDataPrezencni() {
        return averagePassDataPrezencni;
    }

    public void setAveragePassDataPrezencni(List<Integer> averagePassDataPrezencni) {
        this.averagePassDataPrezencni = averagePassDataPrezencni;
    }

    public List<Integer> getAverageFailDataPrezencni() {
        return averageFailDataPrezencni;
    }

    public void setAverageFailDataPrezencni(List<Integer> averageFailDataPrezencni) {
        this.averageFailDataPrezencni = averageFailDataPrezencni;
    }
}
