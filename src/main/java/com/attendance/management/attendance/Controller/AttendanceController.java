package com.attendance.management.attendance.Controller;

import com.attendance.management.attendance.Service.AttendanceService;
import com.attendance.management.attendance.entity.attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }
    @PostMapping
    public ResponseEntity<String> createAttendance(@RequestBody attendance attendance) {
        attendanceService.createAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body("Attendance created successfully");
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateAttendance(@PathVariable String employeeId, @RequestBody attendance attendance) {
        attendanceService.updateAttendance(employeeId, attendance);
        return ResponseEntity.status(HttpStatus.OK).body("Attendance updated successfully");
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteAttendance(@PathVariable String employeeId) {
        attendanceService.deleteAttendance(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Attendance deleted successfully");
    }
     @PostMapping("/upload")
    public ResponseEntity<String> uploadAttendanceFile(@RequestParam("file") MultipartFile file) {
        try {
            attendanceService.uploadAttendanceFile(file);
            return ResponseEntity.status(HttpStatus.CREATED).body("Attendance data uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload attendance data");
        }
    }

}
