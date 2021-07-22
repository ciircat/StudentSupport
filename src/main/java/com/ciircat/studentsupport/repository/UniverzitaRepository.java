package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.Univerzita;
import org.springframework.data.repository.CrudRepository;

public interface UniverzitaRepository extends CrudRepository<Univerzita, Long> {
    Univerzita findUniverzitaByUniverzitniIdentifikacniKod(String univerzitniIdentifikacniKod);
}
