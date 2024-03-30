package com.attendance.management.attendance.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;



@Entity
public class employee {
    @Id
    private String employeeId;
    private String name;
    private String category;
    private double wage;
    private double siderIncentive;
    private double fitIncentive;
    private String department;
    private String subDepartment;
    private Date joiningDate;
    private String village;
    private long phoneNumber;
    

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public double getWage() {
        return wage;
    }
    public void setWage(double wage) {
        this.wage = wage;
    }
    public double getSiderIncentive() {
        return siderIncentive;
    }
    public void setSiderIncentive(double siderIncentive) {
        this.siderIncentive = siderIncentive;
    }
    public double getFitIncentive() {
        return fitIncentive;
    }
    public void setFitIncentive(double fitIncentive) {
        this.fitIncentive = fitIncentive;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSubDepartment() {
        return subDepartment;
    }
    public void setSubDepartment(String subDepartment) {
        this.subDepartment = subDepartment;
    }
    public String getJoiningDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.joiningDate);
    }
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
    public String getVillage() {
        return village;
    }
    public void setVillage(String village) {
        this.village = village;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
   

}
