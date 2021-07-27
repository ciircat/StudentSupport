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
}
