package com.attendance.management.attendance.repository;

import com.attendance.management.attendance.entity.dailyAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dailyAttenRepo extends JpaRepository<dailyAttendance,String> {
    
}



