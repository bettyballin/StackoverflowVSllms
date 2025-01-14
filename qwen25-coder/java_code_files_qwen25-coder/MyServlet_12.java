import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MyServlet_12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Start or retrieve the current session
        HttpSession session = request.getSession();

        // Store sensitive data in the session
        String userId = request.getParameter("user_id");  // Example parameter
        session.setAttribute("userId", userId);

        // Redirect to next page or continue processing
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);  // Get existing session without creating one

        if (session != null && session.getAttribute("userId") != null) {
            String userId = (String) session.getAttribute("userId");
            // Use the stored data for further processing
            // For example: Fetch user-specific data from a database

            response.getWriter().append("User ID from session: ").append(userId);
        } else {
            // Handle no session or missing attribute
        }
    }

    public static void main(String[] args) {
    }
}