package com.attendance.management.attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;


@Entity
public class attendance {
    @Id
    private String employeeId;
    private String employeeName;
    private Date date;
    private double WorkDay;
    private double OTday;
   
    public void setDate(Date date) {
        this.date = date;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setOTday(double oTday) {
        OTday = oTday;
    }
    public void setWorkDay(double workDay) {
        WorkDay = workDay;
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
    public double getWorkDay() {
        return WorkDay;
    }
   
    public double getOTday() {
        return OTday;
    }


}
