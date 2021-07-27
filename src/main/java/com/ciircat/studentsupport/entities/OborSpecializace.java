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
}
