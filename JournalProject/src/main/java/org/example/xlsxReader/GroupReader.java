package org.example.xlsxReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Group;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class GroupReader {

    public List<Group> read(String filePath) throws Exception {

        List<Group> groups = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                groups.add(createGroup(row));
            }
        }

        return groups;
    }

    private Group createGroup(Row row) {

        Group group = new Group();

        group.setId((int) row.getCell(0).getNumericCellValue());
        group.setName(row.getCell(1).getStringCellValue());

        return group;
    }
}
