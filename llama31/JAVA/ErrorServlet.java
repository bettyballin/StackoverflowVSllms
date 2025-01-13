import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the original request URI from the request attribute
        String originalRequestUri = (String) request.getAttribute("javax.servlet.forward.request_uri");

        // Determine which error page to display based on the original request URI
        if (originalRequestUri != null && originalRequestUri.contains("/admin/")) {
            // Display admin error page
            request.getRequestDispatcher("/adminError.jsp").forward(request, response);
        } else {
            // Display user error page
            request.getRequestDispatcher("/userError.jsp").forward(request, response);
        }
    }
}