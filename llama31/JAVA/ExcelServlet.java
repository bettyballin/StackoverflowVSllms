import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create an Excel workbook and sheet
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("MySheet");

        // Get the data from your table (example: a list of strings)
        String[] data = {"Column1", "Column2", "Column3"};

        // Create a header row
        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < data.length; i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(data[i]);
        }

        // Fill in the data
        for (int i = 1; i <= 10; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < data.length; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue("Row " + i + " Col " + j);
            }
        }

        // Set the response headers to force the browser to download the file
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=MyExcelFile.xls");

        // Write the workbook to the response output stream
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}