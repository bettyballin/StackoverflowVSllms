import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import jxl.*;
import jxl.write.*;
import jxl.read.biff.BiffException;

public class DynamicFileServlet extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // Set the content type to force browser to open 'Save As' dialog for downloading file
        response.setContentType("application/octet-stream");

        String filename = "your-dynamic-filename";  // You can generate this dynamically based on request parameters

        // Setting the header, name of your dynamic file with or without file extension should be added here
        response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + ".xls" + "\"");

        // You can now write data directly into ServletOutputStream object 'out' and it will be downloaded as dynamic excel(/any other type) file automatically by the browser.
        OutputStream out = response.getOutputStream();
        WorkbookSettings ws = new WorkbookSettings();

        // Variables added to make the code compile
        boolean check_if_file_exists = false;
        boolean overwrite = true;

        try {
            // Create workbook
            WritableWorkbook writableWorkbook;
            if (check_if_file_exists || !overwrite) {
                // Reading existing workbook
                File inputFile = new File(filename);
                Workbook existingWorkbook = Workbook.getWorkbook(inputFile, ws);
                writableWorkbook = Workbook.createWorkbook(out, existingWorkbook);
            } else {
                // Creating new workbook
                writableWorkbook = Workbook.createWorkbook(out, ws);
            }
            // Create sheet and write data to it ... (write your file content code here)

            // Write and close the workbook
            writableWorkbook.write();
            writableWorkbook.close();
        } catch (IOException | WriteException | BiffException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            out.flush();   // Flush the output stream
            out.close();   // Close it after use
        }
    }

    public static void main(String[] args) {
    }
}