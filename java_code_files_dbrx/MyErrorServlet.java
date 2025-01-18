import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class MyErrorServlet extends HttpServlet {
    // Implement doGet & doPost...
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the HTTP response code. Typically it will be like 503.
        resp.setStatus(503);
        // Add custom Error message as JSON/HTML output
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>Website under maintenance</body></html>");
    }

    public static void main(String[] args) {
    }
}