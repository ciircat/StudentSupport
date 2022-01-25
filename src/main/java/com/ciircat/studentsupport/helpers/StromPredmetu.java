package com.ciircat.studentsupport.helpers;

import java.util.ArrayList;
import java.util.List;

public class StromPredmetu {
    private List<PredmetVTydnu> strom;

    public PredmetVTydnu insertPredmetVTydnu(PredmetVTydnu predmetVTydnu){
        this.strom.add(predmetVTydnu);
        return predmetVTydnu;
    }

    public StromPredmetu(){
        this.strom = new ArrayList<>();
    }

    public List<PredmetVTydnu> getStrom() {
        return strom;
    }

    public void setStrom(List<PredmetVTydnu> strom) {
        this.strom = strom;
    }
}
