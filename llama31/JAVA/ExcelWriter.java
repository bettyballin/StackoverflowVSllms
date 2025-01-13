import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public static void main(String[] args) throws IOException {
        // Create a new Excel workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        // Create a new sheet
        HSSFSheet sheet = workbook.createSheet("Table");

        // Create a header row
        HSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Column 1");
        headerRow.createCell(1).setCellValue("Column 2");

        // Create data rows
        for (int i = 1; i <= 10; i++) {
            HSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue("Value " + i);
            row.createCell(1).setCellValue("Value " + i);
        }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("example.xls")) {
            workbook.write(fileOut);
        }
    }
}