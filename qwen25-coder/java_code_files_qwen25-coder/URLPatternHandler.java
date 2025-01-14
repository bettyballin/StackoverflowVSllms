import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLPatternHandler extends HttpServlet {
    // Java Servlet code snippet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.matches("/yourapp/something_[a-zA-Z0-9_-]+")) {
            // Handle the specific pattern you need
            String identifier = uri.substring("/yourapp/something_".length());
            // Process 'identifier' which is alphanumeric after underscore
        } else {
            // Handle invalid requests or redirect to error page
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    public static void main(String[] args) {
    }
}