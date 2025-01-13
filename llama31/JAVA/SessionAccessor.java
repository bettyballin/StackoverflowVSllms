import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionAccessor {
    public static void main(String[] args) {
        // Note: HttpServletRequest and HttpSession objects typically come from a servlet or web framework.
        // For demonstration purposes, assume they are created elsewhere in the application.
        HttpServletRequest request = null; // This should be obtained from a servlet or web framework

        // Get the HttpSession
        HttpSession session = request.getSession();

        // Get the userBean from the session
        User userBean = (User) session.getAttribute("userBean");

        // Now you can use the userBean
        System.out.println(userBean);
    }
}

// Assuming a basic User class for demonstration purposes
class User {
    // Add your properties and methods here
}