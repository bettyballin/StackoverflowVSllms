import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/downloadCsv")
public class DownloadCsvServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/csv");
        // Set the Content-Disposition header to suggest a filename with .csv extension
        response.setHeader("Content-Disposition", "attachment; filename=my_generated_file.csv");
        
        // Your logic to generate CSV data goes here
        // For example, writing some dummy CSV content:
        PrintWriter out = response.getWriter();
        out.println("Column1,Column2,Column3");
        out.println("Value1,Value2,Value3");
        out.flush();
        out.close();
    }
}