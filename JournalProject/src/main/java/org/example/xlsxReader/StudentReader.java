package org.example.xlsxReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Student;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {

    public List<Student> read(String filePath) throws Exception {

        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                students.add(createStudent(row));
            }
        }

        return students;
    }

    private Student createStudent(Row row) {

        Student student = new Student();

        student.setId((int) row.getCell(0).getNumericCellValue());
        student.setName(row.getCell(1).getStringCellValue());
        student.setGroupId((int) row.getCell(2).getNumericCellValue());

        return student;
    }
}
