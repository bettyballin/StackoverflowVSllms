import java.lang.String;
import java.lang.Set;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelServlet_1_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response headers
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        resp.setHeader("Content-Disposition", "attachment; filename=\"example.xlsx\"");

        // Create Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Example");

        // Create a row and put some cells in it
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello, World!");

        // Write the workbook to the response
        try (OutputStream out = resp.getOutputStream()) {
            workbook.write(out);
        } finally {
            workbook.close();
        }
    }

    public static void main(String[] args) {
        // Create an instance of the servlet and call the doGet method
        ExcelServlet_1 servlet = new ExcelServlet_1();
        HttpServletRequest req = null; // You would need to create a HttpServletRequest object or mock it
        HttpServletResponse resp = null; // You would need to create a HttpServletResponse object or mock it
        try {
            servlet.doGet(req, resp);
        } catch (ServletException e) {
            System.out.println("ServletException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}