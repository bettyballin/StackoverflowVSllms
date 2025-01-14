import java.lang.String;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Perform your authentication logic here
        boolean isAuthenticated = authenticate(request);

        if (isAuthenticated) {
            // Invalidate the old session and create a new one
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            
            // Create a new session with a new session ID
            HttpSession newSession = request.getSession(true);
            
            // Add user information to the new session
            String username = request.getParameter("username");
            newSession.setAttribute("user", username);

            response.sendRedirect("/welcome.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed.");
        }
    }

    private boolean authenticate(HttpServletRequest request) {
        // Placeholder for authentication logic
        return true;  // Assume authentication succeeds for example purposes
    }

	public static void main(String[] args) {
	}
}