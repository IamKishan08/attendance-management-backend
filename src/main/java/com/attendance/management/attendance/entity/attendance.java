package com.attendance.management.attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;


@Entity
public class attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String employeeName;
    private Date date;
    private double WorkDay;
    private double OTday;
   
    

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
    public Long getId() {
        return id;
    }
    public double getOTday() {
        return OTday;
    }


}
