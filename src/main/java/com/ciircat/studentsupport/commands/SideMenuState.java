package com.ciircat.studentsupport.commands;

public class SideMenuState {
    private String faculty;
    private String studyProgram;
    private String academicYear;
    private String value;
    private String typeOfStudium;
    private String semester;
    private String minimumCredit;

    public SideMenuState(){}

    public SideMenuState(String minimumCredit, String semester, String faculty, String studyProgram, String academicYear, String value, String typeOfStudium) {
        this.value = value;
        this.faculty = faculty;
        this.studyProgram = studyProgram;
        this.academicYear = academicYear;
        this.typeOfStudium = typeOfStudium;
        this.semester = semester;
        this.minimumCredit = minimumCredit;
    }

    public String getMinimumCredit() {
        return minimumCredit;
    }

    public void setMinimumCredit(String minimumCredit) {
        this.minimumCredit = minimumCredit;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTypeOfStudium() {
        return typeOfStudium;
    }

    public void setTypeOfStudium(String typeOfStudium) {
        this.typeOfStudium = typeOfStudium;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
}
