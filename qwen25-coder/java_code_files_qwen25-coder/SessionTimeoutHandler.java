import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionTimeoutHandler extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("lastAccessedTime") == null) {
            // Assuming this page is shown when a timeout occurs
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Your session has timed out.</h1>");
            response.getWriter().println("<p>Please log in again and continue your work.</p>");
            response.getWriter().println("</body></html>");
        } else {
            // Continue with the request as usual
            processRequest(request, response);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Normal processing logic here...
        HttpSession session = request.getSession(true);
        long currentTime = System.currentTimeMillis();
        if (session.getAttribute("lastAccessedTime") != null && 
            (currentTime - (Long)session.getAttribute("lastAccessedTime")) > 120 * 60 * 1000) {
            // Handle expired logic...
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public static void main(String[] args) {
    }
}