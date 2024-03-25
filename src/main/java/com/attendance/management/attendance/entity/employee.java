package com.attendance.management.attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String name;
    private String category;

    public String getEmployeeId() {
        return employeeId;
    }
    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

}
