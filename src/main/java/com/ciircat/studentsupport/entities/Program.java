package com.ciircat.studentsupport.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "program")
public class Program extends BaseEntity{
    private String nazev;
    private String kodProgramu;
}
