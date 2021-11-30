package com.ciircat.studentsupport.entities;

import com.ciircat.studentsupport.enums.Pohlavi;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{
    private String studentovoId;
    private String pohlavi;
    @OneToMany(mappedBy = "student")
    private List<Studium> studia;

    public String getStudentovoId() {
        return studentovoId;
    }

    public void setStudentovoId(String studentovoId) {
        this.studentovoId = studentovoId;
    }

    public String getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi = pohlavi;
    }

    public List<Studium> getStudia() {
        return studia;
    }

    public void setStudia(List<Studium> studia) {
        this.studia = studia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentovoId.equals(student.studentovoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentovoId);
    }
}
