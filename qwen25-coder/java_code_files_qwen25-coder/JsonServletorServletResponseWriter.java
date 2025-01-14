import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonServletorServletResponseWriter extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Your logic to generate JSON content
        String jsonResponse = "{\"key\":\"value\"}";

        // Set the correct content type
        response.setContentType("application/json");
        
        // Write the JSON to the response output stream
        try (PrintWriter out = response.getWriter()) {
            out.print(jsonResponse);
            out.flush();
        }
    }

    public static void main(String[] args) {
    }
}