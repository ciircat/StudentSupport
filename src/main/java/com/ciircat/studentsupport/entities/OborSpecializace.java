package com.ciircat.studentsupport.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "obor_specializace")
public class OborSpecializace extends BaseEntity{
    private String nazevOboruSpecializace;
    private String kodOboruSpecializace;
    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    private Program program;

    @ManyToMany
    @JoinTable(
            name = "predmet_oborspecializace", joinColumns = @JoinColumn(name = "predmet_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "oborspecializace_id", referencedColumnName = "id")
    )
    private Set<Predmet> predmetyOboruSpecializace;

    @OneToOne(mappedBy = "oborSpecializace")
    private Studium studium;

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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Set<Predmet> getPredmetyOboruSpecializace() {
        return predmetyOboruSpecializace;
    }

    public void setPredmetyOboruSpecializace(Set<Predmet> predmetyOboruSpecializace) {
        this.predmetyOboruSpecializace = predmetyOboruSpecializace;
    }

    public Studium getStudium() {
        return studium;
    }

    public void setStudium(Studium studium) {
        this.studium = studium;
    }
}
