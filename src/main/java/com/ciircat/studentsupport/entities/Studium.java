package com.ciircat.studentsupport.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "studium")
public class Studium extends BaseEntity{

    private String formaStudia;
    private String vysledekPrvnihoRokuStudia;
    private String vysledekZimnihoSemestru;
    private String rokMaturitniZkousky;

    @ElementCollection
    private List<Integer> kumulovaneKredityPoTydnech;
    /*
    * Pozice v listu odpovídá týdnu a samotná entita na dané pozici je String reprezentující id daného předmětu v DB
    * Jelikož student může v daném týdnu absolvovat více předmětů, budou jednotlivě předměty oddělený čárkou tedy symbolem ,
    * */
    @ElementCollection
    private List<String> absolvovanePredmetyPoTydnech = new ArrayList<>(52);

    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    private Program program;

    @OneToMany(mappedBy = "studium", fetch= FetchType.EAGER)
    private List<Pokus> pokusy = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "oborSpecializace_id", referencedColumnName = "id")
    private OborSpecializace oborSpecializace;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studium studium = (Studium) o;
        return Objects.equals(program, studium.program) && Objects.equals(student, studium.student) && Objects.equals(oborSpecializace, studium.oborSpecializace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(program, student, oborSpecializace);
    }

    public Pokus addPokus(Pokus pokus){
        this.pokusy.add(pokus);
        return pokus;
    }

    public void addAbsolvovanyPredmetVDanemTydnu(Predmet predmet, int tyden){
        String previously = this.absolvovanePredmetyPoTydnech.get(tyden - 1);
        if (previously.equals("")){
            this.absolvovanePredmetyPoTydnech.add(Long.toString(predmet.getId()));
        }else {
            this.absolvovanePredmetyPoTydnech.add(","+Long.toString(predmet.getId()));
        }

    }

    public String getVysledekZimnihoSemestru() {
        return vysledekZimnihoSemestru;
    }

    public void setVysledekZimnihoSemestru(String vysledekZimnihoSemestru) {
        this.vysledekZimnihoSemestru = vysledekZimnihoSemestru;
    }

    public String getVysledekPrvnihoRokuStudia() {
        return vysledekPrvnihoRokuStudia;
    }

    public void setVysledekPrvnihoRokuStudia(String vysledekPrvnihoRokuStudia) {
        this.vysledekPrvnihoRokuStudia = vysledekPrvnihoRokuStudia;
    }

    public String getFormaStudia() {
        return formaStudia;
    }

    public void setFormaStudia(String formaStudia) {
        this.formaStudia = formaStudia;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<Pokus> getPokusy() {
        return pokusy;
    }

    public void setPokusy(List<Pokus> pokusy) {
        this.pokusy = pokusy;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public OborSpecializace getOborSpecializace() {
        return oborSpecializace;
    }

    public void setOborSpecializace(OborSpecializace oborSpecializace) {
        this.oborSpecializace = oborSpecializace;
    }

    public String getRokMaturitniZkousky() {
        return rokMaturitniZkousky;
    }

    public void setRokMaturitniZkousky(String rokMaturitniZkousky) {
        this.rokMaturitniZkousky = rokMaturitniZkousky;
    }

    public List<Integer> getKumulovaneKredityPoTydnech() {
        return kumulovaneKredityPoTydnech;
    }

    public void setKumulovaneKredityPoTydnech(List<Integer> kumulovaneKredityPoTydnech) {
        this.kumulovaneKredityPoTydnech = kumulovaneKredityPoTydnech;
    }

    public List<String> getAbsolvovanePredmetyPoTydnech() {
        return absolvovanePredmetyPoTydnech;
    }

    public void setAbsolvovanePredmetyPoTydnech(List<String> absolvovanePredmetyPoTydnech) {
        this.absolvovanePredmetyPoTydnech = absolvovanePredmetyPoTydnech;
    }
}