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

    public DummyData(SideMenuState sideMenuState) {
        if (sideMenuState.getAcademicYear().equals("2021")){
            this.setNumberOfStudents(100);
            this.setPassStudentsWinter(90);
            this.setFailStudentsWinter(10);
            this.setPassStudentsSummer(85);
            this.setFailStudentsSummer(5);
            this.setFailStudentsTotal(15);
            this.setInterventionCreditIntervalStart(20);
            this.setInterventionCreditIntervalStop(30);
            List<Integer> data = new ArrayList<>();
            data.add(0);
            data.add(0);
            data.add(0);
            data.add(0);
            data.add(0);
            data.add(0);
            data.add(2);
            data.add(4);
            data.add(7);
            data.add(8);
            data.add(11);
            data.add(11);
            data.add(11);
            data.add(11);
            data.add(12);
            data.add(15);
            data.add(16);
            data.add(17);
            data.add(20);
            data.add(20);
            data.add(20);
            data.add(20);
            data.add(22);
            data.add(24);
            data.add(26);
            data.add(28);
            data.add(30);
            data.add(31);
            data.add(31);
            data.add(31);
            data.add(31);
            data.add(31);
            data.add(32);
            data.add(32);
            data.add(32);
            data.add(34);
            data.add(38);
            data.add(39);
            data.add(39);
            data.add(39);
            data.add(39);
            data.add(40);
            data.add(42);
            data.add(44);
            data.add(46);
            data.add(48);
            data.add(50);
            data.add(51);
            data.add(52);
            data.add(53);
            data.add(54);
            data.add(55);
            this.dataPassed = data;
            List<Integer> data2 = new ArrayList<>();
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(1);
            data2.add(1);
            data2.add(2);
            data2.add(5);
            data2.add(6);
            data2.add(7);
            data2.add(10);
            data2.add(10);
            data2.add(10);
            data2.add(10);
            data2.add(12);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(20);
            data2.add(22);
            data2.add(24);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            this.dataFailed = data2;
        }else if (sideMenuState.getAcademicYear().equals("2020")){
            this.setNumberOfStudents(110);
            this.setPassStudentsWinter(99);
            this.setFailStudentsWinter(11);
            this.setPassStudentsSummer(99);
            this.setFailStudentsSummer(0);
            this.setFailStudentsTotal(11);
            this.setInterventionCreditIntervalStart(23);
            this.setInterventionCreditIntervalStop(31);
            List<Integer> data = new ArrayList<>();
            data.add(0);
            data.add(0);
            data.add(2);
            data.add(2);
            data.add(2);
            data.add(2);
            data.add(2);
            data.add(7);
            data.add(8);
            data.add(8);
            data.add(15);
            data.add(15);
            data.add(15);
            data.add(15);
            data.add(15);
            data.add(15);
            data.add(16);
            data.add(17);
            data.add(22);
            data.add(24);
            data.add(24);
            data.add(24);
            data.add(24);
            data.add(24);
            data.add(26);
            data.add(28);
            data.add(30);
            data.add(31);
            data.add(31);
            data.add(31);
            data.add(31);
            data.add(31);
            data.add(32);
            data.add(32);
            data.add(32);
            data.add(34);
            data.add(38);
            data.add(39);
            data.add(39);
            data.add(39);
            data.add(39);
            data.add(40);
            data.add(40);
            data.add(40);
            data.add(40);
            data.add(40);
            data.add(40);
            data.add(40);
            data.add(40);
            data.add(53);
            data.add(54);
            data.add(55);
            this.dataPassed = data;
            List<Integer> data2 = new ArrayList<>();
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(0);
            data2.add(1);
            data2.add(1);
            data2.add(2);
            data2.add(5);
            data2.add(6);
            data2.add(7);
            data2.add(10);
            data2.add(10);
            data2.add(10);
            data2.add(10);
            data2.add(12);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(14);
            data2.add(20);
            data2.add(22);
            data2.add(24);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            data2.add(26);
            this.dataFailed = data2;
        }
        else {
            List<Integer> data = new ArrayList<>();
            this.dataPassed = data;
            this.dataFailed =data;
        }
    }

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
