import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int inactivityPeriod = 1 * 60; // One minute default timeout (minutes * seconds)

        // Sets the session invalid after one minute (60 seconds).
        HttpSession currentSession = request.getSession();
        if (currentSession != null) {
            response.setHeader("Refresh", String.valueOf(inactivityPeriod));
            // Redirect URL to load after timeout
            response.setHeader("Location", "/nm/extraNet/asp/error.jsp");
        }
    }
}