import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet_1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // Authenticate user...
        if (/* authentication successful */) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            HttpSession newSession = req.getSession(true);
            // Transfer any existing session attributes to the new session
            // ...
        }
    }
}