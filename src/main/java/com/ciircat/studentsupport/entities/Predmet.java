package com.ciircat.studentsupport.entities;

import com.ciircat.studentsupport.enums.Semestr;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "predmet")
public class Predmet extends BaseEntity{
    private String kodPracoviste;
    private String kodPredmetu;
    private String kombinovanyKod;
    private String nazevPredmetu;
    private int pocetKreditu;
    private String typUkonceni;
    @OneToMany(mappedBy = "predmet")
    private List<Pokus> pokusy;

    @ManyToMany(mappedBy = "predmetyProgramu")
    private Set<Program> programy;

    @ManyToMany(mappedBy = "predmetyOboruSpecializace")
    private Set<OborSpecializace> oborySpecializace;

    public String getKodPracoviste() {
        return kodPracoviste;
    }

    public void setKodPracoviste(String kodPracoviste) {
        this.kodPracoviste = kodPracoviste;
    }

    public String getKodPredmetu() {
        return kodPredmetu;
    }

    public void setKodPredmetu(String kodPredmetu) {
        this.kodPredmetu = kodPredmetu;
    }

    public String getKombinovanyKod() {
        return kombinovanyKod;
    }

    public void setKombinovanyKod(String kombinovanyKod) {
        this.kombinovanyKod = kombinovanyKod;
    }

    public String getNazevPredmetu() {
        return nazevPredmetu;
    }

    public void setNazevPredmetu(String nazevPredmetu) {
        this.nazevPredmetu = nazevPredmetu;
    }

    public int getPocetKreditu() {
        return pocetKreditu;
    }

    public void setPocetKreditu(int pocetKreditu) {
        this.pocetKreditu = pocetKreditu;
    }

    public String getTypUkonceni() {
        return typUkonceni;
    }

    public void setTypUkonceni(String typUkonceni) {
        this.typUkonceni = typUkonceni;
    }

    public List<Pokus> getPokusy() {
        return pokusy;
    }

    public void setPokusy(List<Pokus> pokusy) {
        this.pokusy = pokusy;
    }

    public Set<Program> getProgramy() {
        return programy;
    }

    public void setProgramy(Set<Program> programy) {
        this.programy = programy;
    }

    public Set<OborSpecializace> getOborySpecializace() {
        return oborySpecializace;
    }

    public void setOborySpecializace(Set<OborSpecializace> oborySpecializace) {
        this.oborySpecializace = oborySpecializace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predmet predmet = (Predmet) o;
        return nazevPredmetu.equals(predmet.nazevPredmetu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazevPredmetu);
    }
}
