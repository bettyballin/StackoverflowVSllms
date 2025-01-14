import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        // Process query here...

        // Send back a simple string response for now (could be HTML or JSON)
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Results for: " + query + "</p>");
    }

    public static void main(String[] args) {
    }
}