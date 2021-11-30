package com.ciircat.studentsupport.helpers;

public class PredmetData {
    private String nazev;
    private int passFailRatio;
    public double pocetA;
    public double pocetB;
    public double pocetC;
    public double pocetD;
    public double pocetE;
    public double pocetF;
    private int procentoA;
    private int procentoB;
    private int procentoC;
    private int procentoD;
    private int procentoE;
    private int procentoF;
    private int posledniUspesnyPokus0;
    private int posledniUspesnyPokus1;
    private int posledniUspesnyPokus2;
    private int posledniUspesnyPokus3;

    public void incrementPosledniUspesnyPokus0(){
        this.posledniUspesnyPokus0++;
    }
    public void incrementPosledniUspesnyPokus1(){
        this.posledniUspesnyPokus1++;
    }
    public void incrementPosledniUspesnyPokus2(){
        this.posledniUspesnyPokus2++;
    }
    public void incrementPosledniUspesnyPokus3(){
        this.posledniUspesnyPokus3++;
    }


    public int getPosledniUspesnyPokus0() {
        return posledniUspesnyPokus0;
    }

    public void setPosledniUspesnyPokus0(int posledniUspesnyPokus0) {
        this.posledniUspesnyPokus0 = posledniUspesnyPokus0;
    }

    public int getPosledniUspesnyPokus1() {
        return posledniUspesnyPokus1;
    }

    public void setPosledniUspesnyPokus1(int posledniUspesnyPokus1) {
        this.posledniUspesnyPokus1 = posledniUspesnyPokus1;
    }

    public int getPosledniUspesnyPokus2() {
        return posledniUspesnyPokus2;
    }

    public void setPosledniUspesnyPokus2(int posledniUspesnyPokus2) {
        this.posledniUspesnyPokus2 = posledniUspesnyPokus2;
    }

    public int getPosledniUspesnyPokus3() {
        return posledniUspesnyPokus3;
    }

    public void setPosledniUspesnyPokus3(int posledniUspesnyPokus3) {
        this.posledniUspesnyPokus3 = posledniUspesnyPokus3;
    }

    public int getProcentoA() {
        return procentoA;
    }

    public void setProcentoA(int procentoA) {
        this.procentoA = procentoA;
    }

    public int getProcentoB() {
        return procentoB;
    }

    public void setProcentoB(int procentoB) {
        this.procentoB = procentoB;
    }

    public int getProcentoC() {
        return procentoC;
    }

    public void setProcentoC(int procentoC) {
        this.procentoC = procentoC;
    }

    public int getProcentoD() {
        return procentoD;
    }

    public void setProcentoD(int procentoD) {
        this.procentoD = procentoD;
    }

    public int getProcentoE() {
        return procentoE;
    }

    public void setProcentoE(int procentoE) {
        this.procentoE = procentoE;
    }

    public int getProcentoF() {
        return procentoF;
    }

    public void setProcentoF(int procentoF) {
        this.procentoF = procentoF;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getPassFailRatio() {
        return passFailRatio;
    }

    public void setPassFailRatio(int passFailRatio) {
        this.passFailRatio = passFailRatio;
    }
}
