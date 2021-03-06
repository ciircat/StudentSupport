package com.ciircat.studentsupport.repository;

import com.ciircat.studentsupport.entities.Fakulta;
import com.ciircat.studentsupport.entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FakultaRepository extends JpaRepository<Fakulta, Long> {
    Fakulta findFakultaByNazevFakulty(String nazevFakulty);

}
