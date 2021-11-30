package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.OborSpecializace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OborSpecializaceRepository extends JpaRepository<OborSpecializace, Long> {

    OborSpecializace findOborSpecializaceByKodOboruSpecializace(String kodOboruSpecializace);
}
