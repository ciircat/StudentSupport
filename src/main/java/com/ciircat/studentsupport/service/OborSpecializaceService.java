package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.OborSpecializace;
import com.ciircat.studentsupport.repository.OborSpecializaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OborSpecializaceService {
    private OborSpecializaceRepository oborSpecializaceRepository;

    @Autowired
    public OborSpecializaceService(OborSpecializaceRepository oborSpecializaceRepository){
        this.oborSpecializaceRepository = oborSpecializaceRepository;
    }

    public OborSpecializace saveOborSpecializace(OborSpecializace oborSpecializace){
        return this.oborSpecializaceRepository.save(oborSpecializace);
    }

    public OborSpecializace findOborSpecializaceByKodOboruSpecializace(String kod){
        return this.oborSpecializaceRepository.findOborSpecializaceByKodOboruSpecializace(kod);
    }


}
