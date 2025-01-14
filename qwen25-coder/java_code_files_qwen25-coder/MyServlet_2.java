import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Poor practice: Directly storing sensitive information in session attributes
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // Password should not be stored!
        session.setAttribute("user", new User(username, password)); // Potential security risk

        // Better practice: Store a user identifier instead of the entire object and sensitive information
        // session.setAttribute("userId", userId);
    }

}

class User {
    private String username;
    private String password; // Password should be handled securely

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters (if needed)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}