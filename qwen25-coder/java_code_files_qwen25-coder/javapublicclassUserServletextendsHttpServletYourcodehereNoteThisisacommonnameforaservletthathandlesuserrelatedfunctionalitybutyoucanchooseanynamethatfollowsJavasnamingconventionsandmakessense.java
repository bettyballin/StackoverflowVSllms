import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userBean = (User) session.getAttribute("userBean");
        
        if (userBean != null) {
            // Access methods of User object here
            int userId = userBean.getId(); // Example access
            System.out.println("User ID: " + userId);
            
            // Process your logic here
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No user bean in session");
        }
    }
    public static void main(String[] args) {
    }
}