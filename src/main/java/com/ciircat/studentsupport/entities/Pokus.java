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
    private int tydenPokusu;
    private String znamka;
    private int ziskanoKreditu;
    private Date datumZapoctu;
    private String hodnoceniZapoctu;
    private int cisloPokusu;
    private boolean predmetSplnen;
    private boolean jdeOKonecnouZnamku;
    private String datumPokusu;


    @ManyToOne
    @JoinColumn(name = "studium_id", referencedColumnName = "id")
    private Studium studium;

    @ManyToOne
    @JoinColumn(name = "predmet_id", referencedColumnName = "id")
    private Predmet predmet;

    public int getCisloPokusu() {
        return cisloPokusu;
    }

    public void setCisloPokusu(int cisloPokusu) {
        this.cisloPokusu = cisloPokusu;
    }

    public boolean isPredmetSplnen() {
        return predmetSplnen;
    }

    public void setPredmetSplnen(boolean predmetBylVTentoPokusSplnen) {
        this.predmetSplnen = predmetBylVTentoPokusSplnen;
    }

    public boolean isJdeOKonecnouZnamku() {
        return jdeOKonecnouZnamku;
    }

    public void setJdeOKonecnouZnamku(boolean predmetBylNakonecSplnen) {
        this.jdeOKonecnouZnamku = predmetBylNakonecSplnen;
    }


    public String getAkademickyRok() {
        return akademickyRok;
    }

    public void setAkademickyRok(String akademickyRok) {
        this.akademickyRok = akademickyRok;
    }

    public String getSemestr() {
        return semestr;
    }

    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    public String getDatumPokusu() {
        return datumPokusu;
    }

    public void setDatumPokusu(String datumPokusu) {
        this.datumPokusu = datumPokusu;
    }

    public int getTydenPokusu() {
        return tydenPokusu;
    }

    public void setTydenPokusu(int tydenPokusu) {
        this.tydenPokusu = tydenPokusu;
    }

    public String getZnamka() {
        return znamka;
    }

    public void setZnamka(String znamka) {
        this.znamka = znamka;
    }

    public int getZiskanoKreditu() {
        return ziskanoKreditu;
    }

    public void setZiskanoKreditu(int ziskanoKreditu) {
        this.ziskanoKreditu = ziskanoKreditu;
    }

    public Date getDatumZapoctu() {
        return datumZapoctu;
    }

    public void setDatumZapoctu(Date datumZapoctu) {
        this.datumZapoctu = datumZapoctu;
    }

    public String getHodnoceniZapoctu() {
        return hodnoceniZapoctu;
    }

    public void setHodnoceniZapoctu(String hodnoceniZapoctu) {
        this.hodnoceniZapoctu = hodnoceniZapoctu;
    }

    public Studium getStudium() {
        return studium;
    }

    public void setStudium(Studium studium) {
        this.studium = studium;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }
}
