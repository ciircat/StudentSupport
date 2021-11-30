package com.ciircat.studentsupport.service;

import com.ciircat.studentsupport.entities.Univerzita;
import com.ciircat.studentsupport.repository.UniverzitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UniverzitaServiceImpl implements UniverzitaServiceInterface{

    private UniverzitaRepository univerzitaRepository;

    @Autowired
    public UniverzitaServiceImpl(UniverzitaRepository univerzitaRepository){
        this.univerzitaRepository = univerzitaRepository;
    }
    @Override
    public Univerzita findById(Long aLong) {
        return null;
    }

    @Override
    public Univerzita save(Univerzita univerzita) {
        return this.univerzitaRepository.save(univerzita);
    }

    @Override
    public Set<Univerzita> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Univerzita univerzita) {

    }

    @Override
    public Univerzita findUniverzitaById(Long id) {
        return null;
    }

    @Override
    public Univerzita findUniverzitaByUniverzitniIdentifikacniKod(String kod) {
        return this.univerzitaRepository.findUniverzitaByUniverzitniIdentifikacniKod(kod);
    }
}
