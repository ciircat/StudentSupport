package com.ciircat.studentsupport.helpers;

import com.ciircat.studentsupport.entities.Predmet;

public class PredmetVTydnu {
    private Predmet predmet;
    private int tyden;

    public PredmetVTydnu(Predmet predmet, int tyden) {
        this.predmet = predmet;
        this.tyden = tyden;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public int getTyden() {
        return tyden;
    }

    public void setTyden(int tyden) {
        this.tyden = tyden;
    }
}
