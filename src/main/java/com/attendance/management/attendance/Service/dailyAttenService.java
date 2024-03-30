package com.attendance.management.attendance.Service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.attendance.management.attendance.entity.dailyAttendance;
import com.attendance.management.attendance.repository.dailyAttenRepo;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;

@Service
public class dailyAttenService {
    @Autowired
    private dailyAttenRepo dailyAttenRepo;

    public List<dailyAttendance> getAllAttendances(){
        return dailyAttenRepo.findAll();
    }

    public void createAttendance(dailyAttendance attendance) {
        dailyAttenRepo.save(attendance);
    }
    public void updateAttendance(String employeeId, dailyAttendance attendance) {
        if (dailyAttenRepo.existsById(employeeId)) {
            dailyAttenRepo.save(attendance);
        } else {
            // Handle error, attendance not found
        }
    }

    public void deleteAttendance(String employeeId) {
        dailyAttenRepo.deleteById(employeeId);
    }
    
    public void uploadExcelFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            // Handle empty file error
            return;
        }

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            Iterator<Row> iterator = sheet.iterator();
            List<dailyAttendance> dailyAttendanceList = new ArrayList<>();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    // Skip header row
                    continue;
                }

                dailyAttendance attendance = new dailyAttendance();
                attendance.setEmployeeId(currentRow.getCell(0).getStringCellValue());
                attendance.setEmployeeName(currentRow.getCell(1).getStringCellValue());
                attendance.setDate(currentRow.getCell(2).getDateCellValue());
                attendance.setWorkDay(currentRow.getCell(3).getNumericCellValue());
                attendance.setOTday(currentRow.getCell(4).getNumericCellValue());

                dailyAttendanceList.add(attendance);
            }

            dailyAttenRepo.saveAll(dailyAttendanceList);
            workbook.close();
        }
    }




}
