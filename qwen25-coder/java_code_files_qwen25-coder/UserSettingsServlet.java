import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userSettings")
public class UserSettingsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assume getUserFromDatabase is a method that fetches the user from the database
        User user = getCurrentUser(request); 
        if (user != null) {
            request.setAttribute("user", user);
        }
        
        // Forward to userSettings.jsp
        request.getRequestDispatcher("/WEB-INF/jsp/userSettings.jsp").forward(request, response);
    }

    private User getCurrentUser(HttpServletRequest request) {
        // Your logic to fetch current user
        return new User(); // Placeholder for actual implementation
    }

    public static void main(String[] args) {
    }
}

class User {
    // Placeholder for User properties and methods
}