import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelExporter {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");

        // Create a row and put some cells in it. Rows are 0 based.
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");

        for (int i = 0; i < 5; i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(String.valueOf(i));
            row.createCell(1).setCellValue("User " + i);
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
    }
}