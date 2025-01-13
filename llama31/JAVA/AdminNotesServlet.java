import java.lang.String;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminnotes/*")
public class AdminNotesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getPathInfo().substring(1);
        if (!hasAccessToAdminNotes(req, userId)) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            return;
        }
        if (adminNotesExistForUser(userId)) {
            // Return the admin notes
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
        }
    }

    private boolean hasAccessToAdminNotes(HttpServletRequest req, String userId) {
        // Implement access control logic here
        return true; // default implementation for compilation
    }

    private boolean adminNotesExistForUser(String userId) {
        // Implement logic to check if admin notes exist for the user
        return true; // default implementation for compilation
    }

    public static void main(String[] args) {
    }
}