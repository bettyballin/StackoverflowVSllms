import java.lang.String;
import java.lang.Set;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Process the form data and query the database
        String formData = request.getParameter("formData");
        // Assume you have a method to query the database and get the list of reports
        String reports = getReportsFromDatabase(formData);
        
        // Set the response content type to text/html
        response.setContentType("text/html");
        
        // Write the response to the output stream
        PrintWriter out = response.getWriter();
        out.println(reports);
        out.close();
    }

    // You need to implement this method to query the database
    private String getReportsFromDatabase(String formData) {
        // Your database logic goes here
        return "Sample reports data"; // Replace with actual database data
    }

    public static void main(String[] args) {
    }
}