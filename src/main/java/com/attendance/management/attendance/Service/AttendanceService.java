package com.attendance.management.attendance.Service;

import com.attendance.management.attendance.entity.attendance;
import com.attendance.management.attendance.repository.attendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttendanceService {
    @Autowired
    private attendanceRepo attendanceRepo;
    public List<attendance> getAllAttendances(){
        return attendanceRepo.findAll();
    }
}
