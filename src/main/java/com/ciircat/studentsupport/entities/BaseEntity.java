package com.ciircat.studentsupport.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//MappedSuperclass říká JPA že ostatní entity od této entity dědí takže není potřeba tuto entitu mapovat do databáze
@MappedSuperclass
public class BaseEntity implements Serializable {
    // strategie IDENTITY říká že se o generaci musí postarat provider databáze
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseEntity(){}

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
