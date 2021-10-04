package com.ciircat.studentsupport.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fakulta")
public class Fakulta extends BaseEntity{
    private String nazevFakulty;
    private String zkratka;

    /*
    * Když mám ManyToOne a né OneToMany tak vím, že jsem na straně N tedy v childu s FK
    * Jméno fieldu, v tomto případě univerzita se musí shodovat s mappedBy="univerzita", protože to je označení proměné,
    * která je FK.
    *
    * atributy v anotaci @JoinColumn:
    * - name mi říká, jak se bude jmenovat sloupec v tabulce Fakulta, který koresponude s fieldem Univerzita univerzita
    * - referencedColumnName mi říká, jak se jmenuje sloupec PK entity, pro kterou je toto FK.
    *
    * */
    @ManyToOne
    @JoinColumn(name = "univerzita_id", referencedColumnName = "id")
    private Univerzita univerzita;

    @OneToMany(mappedBy = "fakulta")
    private List<Program> programy;

    public String getNazevFakulty() {
        return nazevFakulty;
    }

    public void setNazevFakulty(String nazevFakulty) {
        this.nazevFakulty = nazevFakulty;
    }

    public String getZkratka() {
        return zkratka;
    }

    public void setZkratka(String zkratka) {
        this.zkratka = zkratka;
    }

    public Univerzita getUniverzita() {
        return univerzita;
    }

    public void setUniverzita(Univerzita univerzita) {
        this.univerzita = univerzita;
    }

    public List<Program> getProgramy() {
        return programy;
    }

    public void setProgramy(List<Program> programy) {
        this.programy = programy;
    }
}
