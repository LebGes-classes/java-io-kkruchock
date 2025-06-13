package org.example.xlsxReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Teacher;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class TeacherReader {

    public List<Teacher> read(String filePath) throws Exception {

        List<Teacher> teachers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                teachers.add(createTeacher(row));
            }
        }

        return teachers;
    }

    private Teacher createTeacher(Row row) {

        Teacher teacher = new Teacher();

        teacher.setId((int) row.getCell(0).getNumericCellValue());
        teacher.setName(row.getCell(1).getStringCellValue());

        return teacher;
    }
}
