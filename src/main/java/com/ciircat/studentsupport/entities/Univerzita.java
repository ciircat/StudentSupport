package com.ciircat.studentsupport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "univerzita")
public class Univerzita extends BaseEntity{

    private String nazevUniverzity;

    private String univerzitniIdentifikacniKod;

    //private List<Fakulta> fakulty;


}
