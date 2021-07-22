package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.Univerzita;

public interface UniverzitaServiceInterface extends CrudServiceInterface<Univerzita,Long>{
    Univerzita findUniverzitaById(Long id);
}
