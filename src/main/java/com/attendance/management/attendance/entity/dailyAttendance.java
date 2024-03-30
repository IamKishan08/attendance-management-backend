package com.attendance.management.attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;


@Entity
public class dailyAttendance {

    @Id
    private String employeeId;
    private String employeeName;
    private Date date;
    private double workDay;
    private double OTday;
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setOTday(double oTday) {
        OTday = oTday;
    }
    public void setWorkDay(double workDay) {
        this.workDay = workDay;
    }

    public Date getDate() {
        return date;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public double getOTday() {
        return OTday;
    }
    public double getWorkDay() {
        return workDay;
    }



}
