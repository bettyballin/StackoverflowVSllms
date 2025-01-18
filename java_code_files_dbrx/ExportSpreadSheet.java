import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;  // For Cell, Row, etc.

public class ExportSpreadSheet extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response)
        throws IOException, ServletException {

        // Creating XLSX file and writing header row:
        XSSFWorkbook workBook = new XSSFWorkbook();
        final String[] headers = {"Column-1", "Column-2"};
        XSSFSheet sheet = workBook.createSheet("My_sheet");
        Row headerRow = sheet.createRow(0); // header row 0 in excel. It starts from '0'

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        try {
            // Writing data in rows:
            for (int i = 1; i <= 15; i++) {
                Row rowData = sheet.createRow(i);   // row index starts from 0
                Cell cell = rowData.createCell(0);        // Setting value to first column of that row.
                cell.setCellValue("Value for Column1");    // Value put in cell.
                cell = rowData.createCell(1);       // Second column from row 'row'.
                cell.setCellValue("Column2_Value");         // Cell '1' gets this value.
            }
            workBook.write(new FileOutputStream("/path/to/my/file.xlsx"));  // write to file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("application/octet-stream");  // for excel files, mimetype is octet stream
        FileInputStream inputStream = new FileInputStream("/path/to/my/file.xlsx"); // Read from the file and write to output stream of response.
        ServletOutputStream outputStream = response.getOutputStream();
        byte buff[] = new byte[1024];
        int readbytes;
        while ((readbytes = inputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, readbytes);  //writing bytes taken from servlet input stream(which gets data from the file) to response buffer till entire length of stream.
        }
        inputStream.close();
        outputStream.close();
        workBook.close();

        File excelFile = new File("/path/to/my/file.xlsx");
        if (excelFile.delete()) {         // Delete temporary file
            System.out.println("The file was successfully deleted.");
        } else {                     // If failed to delete temporary XLS sheet, just return message. It's a harmless error in this case
            System.err.print("Error deleting the file.");
        }
    }

    public static void main(String[] args) {
    }
}