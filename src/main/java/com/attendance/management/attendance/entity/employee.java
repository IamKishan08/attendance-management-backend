package com.attendance.management.attendance.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;



@Entity
public class employee {
    @Id
    private String employeeId;
    private String name;
    private String category;
    

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
   

}
