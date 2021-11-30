package com.ciircat.studentsupport.helpers;

import com.ciircat.studentsupport.commands.SideMenuState;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private List<Integer> dataPassed;
    private List<Integer> dataFailed;
    private int numberOfStudents;
    private int passStudentsWinter;
    private int failStudentsWinter;
    private int passStudentsSummer;
    private int failStudentsSummer;
    private int failStudentsTotal;
    private int interventionCreditIntervalStart;
    private int interventionCreditIntervalStop;



    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getPassStudentsWinter() {
        return passStudentsWinter;
    }

    public void setPassStudentsWinter(int passStudentsWinter) {
        this.passStudentsWinter = passStudentsWinter;
    }

    public int getFailStudentsWinter() {
        return failStudentsWinter;
    }

    public void setFailStudentsWinter(int failStudentsWinter) {
        this.failStudentsWinter = failStudentsWinter;
    }

    public int getPassStudentsSummer() {
        return passStudentsSummer;
    }

    public void setPassStudentsSummer(int passStudentsSummer) {
        this.passStudentsSummer = passStudentsSummer;
    }

    public int getFailStudentsSummer() {
        return failStudentsSummer;
    }

    public void setFailStudentsSummer(int failStudentsSummer) {
        this.failStudentsSummer = failStudentsSummer;
    }

    public int getFailStudentsTotal() {
        return failStudentsTotal;
    }

    public void setFailStudentsTotal(int failStudentsTotal) {
        this.failStudentsTotal = failStudentsTotal;
    }

    public int getInterventionCreditIntervalStart() {
        return interventionCreditIntervalStart;
    }

    public void setInterventionCreditIntervalStart(int interventionCreditIntervalStart) {
        this.interventionCreditIntervalStart = interventionCreditIntervalStart;
    }

    public int getInterventionCreditIntervalStop() {
        return interventionCreditIntervalStop;
    }

    public void setInterventionCreditIntervalStop(int interventionCreditIntervalStop) {
        this.interventionCreditIntervalStop = interventionCreditIntervalStop;
    }

    public List<Integer> getDataPassed() {
        return dataPassed;
    }

    public void setDataPassed(List<Integer> dataPassed) {
        this.dataPassed = dataPassed;
    }

    public List<Integer> getDataFailed() {
        return dataFailed;
    }

    public void setDataFailed(List<Integer> dataFailed) {
        this.dataFailed = dataFailed;
    }
}
