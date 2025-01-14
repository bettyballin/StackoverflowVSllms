import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;

public class RotateTextInCell {
    public static void main(String[] args) throws Exception {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rotated Text Example");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("This is rotated text!");

        // Create or retrieve a cell style to apply rotation
        CellStyle cellStyle = workbook.createCellStyle();
        // Set the rotation angle (90 degrees clockwise)
        short degreeRotation = 90;
        cellStyle.setRotation(degreeRotation);

        // Apply the style with rotated text to the cell
        cell.setCellStyle(cellStyle);

        try (FileOutputStream fileOut = new FileOutputStream("workbook.xls")) {
            workbook.write(fileOut);
        }

        workbook.close();
    }
}