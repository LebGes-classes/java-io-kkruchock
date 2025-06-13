package org.example.xlsxReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Journal;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class JournalReader {

    public List<Journal> read(String filePath) throws Exception {

        List<Journal> journals = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                journals.add(createJournal(row));
            }
        }

        return journals;
    }

    private Journal createJournal(Row row) {

        Journal journal = new Journal();

        journal.setTeacherId((int) row.getCell(0).getNumericCellValue());
        journal.setGroupId((int) row.getCell(1).getNumericCellValue());
        journal.setSubjectId((int) row.getCell(2).getNumericCellValue());

        return journal;
    }
}
