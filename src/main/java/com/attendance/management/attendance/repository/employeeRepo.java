package com.attendance.management.attendance.repository;


import com.attendance.management.attendance.entity.employee; 

import org.springframework.data.jpa.repository.JpaRepository;


public interface employeeRepo extends JpaRepository<employee,Long> {

    
}