package com.attendance.management.attendance.Service;


import com.attendance.management.attendance.entity.employee;
import com.attendance.management.attendance.repository.employeeRepo;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@Service
public class EmployeeService {
    @Autowired
    private employeeRepo employeeRepo;
    public List<employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public void createEmployee(employee employee) {
        employeeRepo.save(employee);
    }

    public void updateEmployee(String employeeId, employee employee) {
        if (employeeRepo.existsById(employeeId)) {
            employeeRepo.save(employee);
        } else {
            // Handle error, employee not found
        }
    }
    public void deleteById(String id) {
        employeeRepo.deleteById(id);
    }
    public void deleteEmployee(String employeeId) {
        employeeRepo.deleteById(employeeId);
    }


    public void uploadEmployeeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            // Handle empty file error
            return;
        }

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming employee data is in the first sheet

            Iterator<Row> iterator = sheet.iterator();
            List<employee> employeeList = new ArrayList<>();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    // Skip header row
                    continue;
                }

                employee employee = new employee();
                employee.setEmployeeId(currentRow.getCell(0).getStringCellValue());
                employee.setName(currentRow.getCell(1).getStringCellValue());
                employee.setCategory(currentRow.getCell(2).getStringCellValue());

                employeeList.add(employee);
            }

            employeeRepo.saveAll(employeeList);
            workbook.close();
        }
    }
    
}
