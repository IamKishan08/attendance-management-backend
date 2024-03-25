package com.attendance.management.attendance.Service;


import com.attendance.management.attendance.entity.employee;
import com.attendance.management.attendance.repository.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private employeeRepo employeeRepo;
    public List<employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    
}
