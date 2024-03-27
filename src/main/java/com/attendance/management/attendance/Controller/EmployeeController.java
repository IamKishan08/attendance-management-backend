package com.attendance.management.attendance.Controller;


import com.attendance.management.attendance.Service.EmployeeService;
import com.attendance.management.attendance.entity.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
   
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody employee employee) {
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable String employeeId, @RequestBody employee employee) {
        employeeService.updateEmployee(employeeId, employee);
        return ResponseEntity.status(HttpStatus.OK).body("Employee updated successfully");
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
    }
    
     @PostMapping("/upload")
    public ResponseEntity<String> uploadEmployeeFile(@RequestParam("file") MultipartFile file) {
        try {
            employeeService.uploadEmployeeFile(file);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee data uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload employee data");
        }
    }
}
