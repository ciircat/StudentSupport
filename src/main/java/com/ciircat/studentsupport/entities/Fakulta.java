package com.ciircat.studentsupport.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fakulta")
public class Fakulta extends BaseEntity{
    private String nazev;
}
