import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getParameter("token");

        // Verify the token with the .NET server
        if (verifyToken(token)) {
            // Grant access to form.jsp
            // You would typically use a RequestDispatcher or HttpServletResponse to forward to the JSP page
            // For this example, we will just print a success message
            System.out.println("Access granted");
        } else {
            // Deny access
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private boolean verifyToken(String token) {
        // Call the .NET server to verify the token
        // You would typically use a library or API to make a call to the .NET server
        // For this example, we will just return true
        return true;
    }

    public static void main(String[] args) {
        // You would typically use a Servlet container like Tomcat to run a Servlet
        // For this example, we will just print a message
        System.out.println("FormServlet main method called");
    }
}