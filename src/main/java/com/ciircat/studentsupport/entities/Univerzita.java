package com.ciircat.studentsupport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "univerzita")
public class Univerzita extends BaseEntity{

    private String nazevUniverzity;

    private String univerzitniIdentifikacniKod;
/*
* anotace OneToMany mi říká, že zde je parent, toto rovnou potvrzuje i argument mappedBy
* mappebdBy="univerzita" mi říká, že jméno proměné univerzita je cizí klíč
* */
    @OneToMany(mappedBy = "univerzita")
    private List<Fakulta> fakulty;

    public String getNazevUniverzity() {
        return nazevUniverzity;
    }

    public void setNazevUniverzity(String nazevUniverzity) {
        this.nazevUniverzity = nazevUniverzity;
    }

    public String getUniverzitniIdentifikacniKod() {
        return univerzitniIdentifikacniKod;
    }

    public void setUniverzitniIdentifikacniKod(String univerzitniIdentifikacniKod) {
        this.univerzitniIdentifikacniKod = univerzitniIdentifikacniKod;
    }

    public List<Fakulta> getFakulty() {
        return fakulty;
    }

    public void setFakulty(List<Fakulta> fakulty) {
        this.fakulty = fakulty;
    }
}
