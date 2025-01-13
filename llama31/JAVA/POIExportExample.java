import java.lang.String;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileOutputStream;
import java.io.IOException;

public class POIExportExample {

    public static void main(String[] args) throws IOException {
        // Example data
        String[][] data = {
                {"Column 1", "Column 2", "Column 3"},
                {"Row 1 Col 1", "Row 1 Col 2", "Row 1 Col 3"},
                {"Row 2 Col 1", "Row 2 Col 2", "Row 2 Col 3"}
        };

        // Export to Excel
        exportToExcel(data, "example.xlsx");

        // Export to Word
        exportToWord(data, "example.docx");
    }

    private static void exportToExcel(String[][] data, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Example Sheet");

        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        try (FileOutputStream out = new FileOutputStream(fileName)) {
            workbook.write(out);
        }
        workbook.close();
    }

    private static void exportToWord(String[][] data, String fileName) throws IOException {
        XWPFDocument document = new XWPFDocument();

        XWPFTable table = document.createTable(data.length, data[0].length);

        for (int i = 0; i < data.length; i++) {
            XWPFTableRow row = table.getRow(i);
            for (int j = 0; j < data[i].length; j++) {
                XWPFTableCell cell = row.getCell(j);
                cell.setText(data[i][j]);
            }
        }

        try (FileOutputStream out = new FileOutputStream(fileName)) {
            document.write(out);
        }
        document.close();
    }
}