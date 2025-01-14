import java.lang.String;
// Import necessary classes
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionExample_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get or create the session for this client
        HttpSession session = request.getSession(true);

        // Retrieve the session ID
        String sessionId = session.getId();

        // You can now use the session ID to track user sessions across requests
        response.getWriter().println("Session ID: " + sessionId);
    }

	public static void main(String[] args) {
	}
}