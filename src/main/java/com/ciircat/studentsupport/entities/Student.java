package com.ciircat.studentsupport.entities;

import com.ciircat.studentsupport.enums.Pohlavi;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{
    private Pohlavi pohlavi;
    @OneToMany(mappedBy = "student")
    private List<Studium> studia;
}
