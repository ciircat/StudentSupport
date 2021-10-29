package com.ciircat.studentsupport.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "program")
public class Program extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "fakulta_id", referencedColumnName = "id")
    private Fakulta fakulta;

    private String nazevProgramu;

    private String kodProgramu;

    @OneToMany(mappedBy = "program")
    private List<OborSpecializace> oborySpecializace;

    @OneToMany(mappedBy = "program")
    private List<Studium> studia;

    @ManyToMany
    @JoinTable(
            name = "predmet_program",
            joinColumns = @JoinColumn(name = "predmet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id")
    )
    private Set<Predmet> predmetyProgramu;

    public Fakulta getFakulta() {
        return fakulta;
    }

    public void setFakulta(Fakulta fakulta) {
        this.fakulta = fakulta;
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

    public List<OborSpecializace> getOborySpecializace() {
        return oborySpecializace;
    }

    public void setOborySpecializace(List<OborSpecializace> oborySpecializace) {
        this.oborySpecializace = oborySpecializace;
    }

    public List<Studium> getStudia() {
        return studia;
    }

    public void setStudia(List<Studium> studia) {
        this.studia = studia;
    }

    public Set<Predmet> getPredmetyProgramu() {
        return predmetyProgramu;
    }

    public void setPredmetyProgramu(Set<Predmet> predmetyProgramu) {
        this.predmetyProgramu = predmetyProgramu;
    }
}
