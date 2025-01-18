import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Workbook workBook = new HSSFWorkbook();
        Sheet sheet = workBook.createSheet("Sample");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello World!");

        CellStyle style = workBook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        style.setRotation((short) 90); // Rotates text to fit in the cell
        cell.setCellStyle(style);

        // Save the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("workbook.xls")) {
            workBook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}