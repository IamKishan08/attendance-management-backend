package com.attendance.management.attendance.repository;

import com.attendance.management.attendance.entity.attendance; 

import org.springframework.data.jpa.repository.JpaRepository;

public interface attendanceRepo  extends JpaRepository<attendance,Long> {
    
}
