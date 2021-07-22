package com.ciircat.studentsupport.entities;

import com.ciircat.studentsupport.enums.Pohlavi;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{
    private Pohlavi pohlavi;
}
