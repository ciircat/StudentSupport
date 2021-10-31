package com.ciircat.studentsupport.commands;

public class SideMenuState {
    private String faculty;
    private String studyProgram;
    private String academicYear;

    public SideMenuState(){}

    public SideMenuState(String faculty, String studyProgram, String academicYear) {
        this.faculty = faculty;
        this.studyProgram = studyProgram;
        this.academicYear = academicYear;
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
