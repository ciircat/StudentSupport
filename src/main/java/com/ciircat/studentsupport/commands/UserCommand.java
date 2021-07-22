package com.ciircat.studentsupport.commands;

public class UserCommand {

    private String username;

    private String password;

    private String passwordAgain;

    private String email;

    private String universityIdentificationCode;

    private String firstName;

    private String lastName;

    public UserCommand(){}

    public UserCommand(String firstName, String lastName, String username, String password, String email, String universityIdentificationCode, String passwordAgain)
    {   this.passwordAgain = passwordAgain;
        this.username = username;
        this.password = password;
        this.email = email;
        this.universityIdentificationCode = universityIdentificationCode;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}