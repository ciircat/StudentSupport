package com.ciircat.studentsupport.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pokus")
public class Pokus extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "studium_id", referencedColumnName = "id")
    private Studium studium;

    @ManyToOne
    @JoinColumn(name = "predmet_id", referencedColumnName = "id")
    private Predmet predmet;
}
