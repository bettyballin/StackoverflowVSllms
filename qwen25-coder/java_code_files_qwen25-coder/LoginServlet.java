import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Logic to check user validity
        boolean isValidUser = authenticate(request);

        if (isValidUser) {
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private boolean authenticate(HttpServletRequest request) {
        // Placeholder for authentication logic
        return false; // or implement actual logic
    }

    public static void main(String[] args) {
    }
}