package com.attendance.management.attendance.Service;

import com.attendance.management.attendance.entity.attendance;
import com.attendance.management.attendance.repository.attendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class AttendanceService {
    @Autowired
    private attendanceRepo attendanceRepo;
    public List<attendance> getAllAttendances(){
        return attendanceRepo.findAll();
    }
    public void createAttendance(attendance attendance) {
        attendanceRepo.save(attendance);
    }

    public void updateAttendance(String employeeId, attendance attendance) {
        if (attendanceRepo.existsById(employeeId)) {
            attendanceRepo.save(attendance);
        } else {
            // Handle error, attendance not found
        }
    }

    public void deleteAttendance(String employeeId) {
        attendanceRepo.deleteById(employeeId);
    }

     public void uploadAttendanceFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            // Handle empty file error
            return;
        }

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming attendance data is in the first sheet

            Iterator<Row> iterator = sheet.iterator();
            List<attendance> attendanceList = new ArrayList<>();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    // Skip header row
                    continue;
                }

                attendance attendance = new attendance();
                attendance.setEmployeeId(currentRow.getCell(0).getStringCellValue());
                attendance.setEmployeeName(currentRow.getCell(1).getStringCellValue());
                attendance.setDate(currentRow.getCell(2).getDateCellValue());
                attendance.setWorkDay(currentRow.getCell(3).getNumericCellValue());
                attendance.setOTday(currentRow.getCell(4).getNumericCellValue());

                attendanceList.add(attendance);
            }

            attendanceRepo.saveAll(attendanceList);
            workbook.close();
        }
    }

}
