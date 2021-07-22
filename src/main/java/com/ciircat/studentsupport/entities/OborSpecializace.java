package com.ciircat.studentsupport.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "obor_specializace")
public class OborSpecializace extends BaseEntity{
    private String nazev;
    private String kodOboruSpecializace;
}
