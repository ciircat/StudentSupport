package com.ciircat.studentsupport.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class DataBarGraph extends BaseEntity{


    private String nazevUniverzity;
    private String kodOboruSpecializace;
    private String nazevfakulty;
    private String nazevProgramu;
    private String akademickyRok;
    private int week;

    @ElementCollection
    private List<Integer> pravdepodobnostPass;



    public List<Integer> getPravdepodobnostPass() {
        return pravdepodobnostPass;
    }

    public void setPravdepodobnostPass(List<Integer> pravdepodobnostPass) {
        this.pravdepodobnostPass = pravdepodobnostPass;
    }


    public String getNazevfakulty() {
        return nazevfakulty;
    }

    public void setNazevfakulty(String nazevfakulty) {
        this.nazevfakulty = nazevfakulty;
    }

    public String getNazevProgramu() {
        return nazevProgramu;
    }

    public void setNazevProgramu(String nazevProgramu) {
        this.nazevProgramu = nazevProgramu;
    }

    public String getAkademickyRok() {
        return akademickyRok;
    }

    public void setAkademickyRok(String akademickyRok) {
        this.akademickyRok = akademickyRok;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getNazevUniverzity() {
        return nazevUniverzity;
    }

    public void setNazevUniverzity(String nazevUniverzity) {
        this.nazevUniverzity = nazevUniverzity;
    }

    public String getKodOboruSpecializace() {
        return kodOboruSpecializace;
    }

    public void setKodOboruSpecializace(String kodOboruSpecializace) {
        this.kodOboruSpecializace = kodOboruSpecializace;
    }
}
