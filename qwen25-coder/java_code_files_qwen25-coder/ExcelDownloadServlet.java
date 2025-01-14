/**
 * To compile this code with javac, ensure that the following libraries are in your classpath:
 * - javax.servlet-api.jar (for HttpServlet and related classes)
 * - poi.jar (for Apache POI classes)
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a new workbook and sheet
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample Data");

        // Example data
        String[] columns = {"ID", "Name"};
        Row headerRow = sheet.createRow(0);
        
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        Object[][] bookData = {
                {1, "John Doe"},
                {2, "Jane Smith"}
        };

        int rowCount = 1;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            
            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        // Autosize columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=sample.xlsx");

            outputStream.writeTo(response.getOutputStream());
        } finally {
            workbook.close();
        }
    }

    public static void main(String[] args) {
    }
}