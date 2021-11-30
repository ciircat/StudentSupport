package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.Fakulta;
import com.ciircat.studentsupport.repository.FakultaRepository;
import org.springframework.stereotype.Service;

@Service
public class FakultaService {
    private FakultaRepository fakultaRepository;

    public FakultaService(FakultaRepository fakultaRepository){
        this.fakultaRepository = fakultaRepository;
    }

    public Fakulta getFakultaByNazevFakulty(String nazevFakulty){
        return this.fakultaRepository.findFakultaByNazevFakulty(nazevFakulty);
    }

    public Fakulta saveFakulta(Fakulta fakulta){
        return this.fakultaRepository.save(fakulta);
    }
}
