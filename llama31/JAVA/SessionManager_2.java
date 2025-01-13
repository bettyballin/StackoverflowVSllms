import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionManager_2_2 {
    public static void main(String[] args) {
        // The following code should be inside a method, like doGet() or doPost() in a Servlet
        // For demonstration purposes, I'll create a dummy HttpServletRequest and HttpSession
        HttpServletRequest request = null; // This should be obtained from a Servlet or a web framework
        HttpSession session = request.getSession(); // This will throw a NullPointerException in this example
        Object user = null; // This should be replaced with the actual user object
        session.setAttribute("currentUser", user);
    }
}