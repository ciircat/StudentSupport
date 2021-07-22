package com.ciircat.studentsupport.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "university_identification_code")
    private String universityIdentificationCode;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "role")
    private String role;


    public User(){}

    public User(Long id, String username, String password, String email, String universityIdentificationCode) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.universityIdentificationCode = universityIdentificationCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversityIdentificationCode() {
        return universityIdentificationCode;
    }

    public void setUniversityIdentificationCode(String universityIdentificationCode) {
        this.universityIdentificationCode = universityIdentificationCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}