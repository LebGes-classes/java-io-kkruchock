package org.example.xlsxReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Score;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreReader {

    public List<Score> read(String filePath) throws Exception {

        List<Score> Scores = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row: sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                Scores.add(createScore(row));
            }
        }

        return Scores;
    }

    private Score createScore(Row row) {

        Score Score = new Score();

        Score.setId((int) row.getCell(0).getNumericCellValue());
        Score.setScore((int) row.getCell(1).getNumericCellValue());
        Score.setSubjectId((int) row.getCell(2).getNumericCellValue());
        Score.setStudentId((int) row.getCell(3).getNumericCellValue());

        return Score;
    }
}
