package com.ciircat.studentsupport.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studium")
public class Studium extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    private Program program;

    @OneToMany(mappedBy = "studium")
    private List<Pokus> pokusy;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "oborSpecializace_id", referencedColumnName = "id")
    private OborSpecializace oborSpecializace;

}
