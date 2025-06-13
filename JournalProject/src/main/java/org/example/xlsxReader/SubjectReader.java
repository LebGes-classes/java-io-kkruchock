package org.example.xlsxReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Subject;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class SubjectReader {

    public List<Subject> read(String filePath) throws Exception {

        List<Subject> subjects = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                subjects.add(createSubject(row));
            }
        }

        return subjects;
    }

    private Subject createSubject(Row row) {

        Subject subject = new Subject();

        subject.setId((int) row.getCell(0).getNumericCellValue());
        subject.setName(row.getCell(1).getStringCellValue());

        return subject;
    }
}
