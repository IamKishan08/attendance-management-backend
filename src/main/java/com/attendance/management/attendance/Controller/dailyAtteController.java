package com.attendance.management.attendance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.attendance.management.attendance.Service.dailyAttenService;
import com.attendance.management.attendance.entity.dailyAttendance;
import java.util.List;
import java.io.IOException;

@RestController
@RequestMapping("api/dailyAttendance")
public class dailyAtteController {
    
    @Autowired
    private dailyAttenService dailyAttendanceService;

    @GetMapping
    public ResponseEntity<List<dailyAttendance>> getAllDailyAttendances() {
        List<dailyAttendance> allDailyAttendances = dailyAttendanceService.getAllAttendances();
        return ResponseEntity.ok().body(allDailyAttendances);
    }

    @PostMapping
    public ResponseEntity<String> createDailyAttendance(@RequestBody dailyAttendance dailyAttendance) {
        dailyAttendanceService.createAttendance(dailyAttendance);
        return ResponseEntity.status(HttpStatus.CREATED).body("Daily attendance created successfully");
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateDailyAttendance(@PathVariable String employeeId, @RequestBody dailyAttendance dailyAttendance) {
        dailyAttendanceService.updateAttendance(employeeId, dailyAttendance);
        return ResponseEntity.status(HttpStatus.OK).body("Daily attendance updated successfully");
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteDailyAttendance(@PathVariable String employeeId) {
        dailyAttendanceService.deleteAttendance(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Daily attendance deleted successfully");
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDailyAttendanceFile(@RequestParam("file") MultipartFile file) {
        try {
            dailyAttendanceService.uploadExcelFile(file);
            return ResponseEntity.status(HttpStatus.CREATED).body("Daily attendance data uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload daily attendance data");
        }
    }



}
