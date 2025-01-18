import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.isRequestedSessionIdValid() && !request.isRequestedSessionIdFromURL() && "YES".equalsIgnoreCase(request.getParameter("remember_me"))) {
            HttpSession session = request.getSession();
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            request.login(userName, password);
            session.invalidate();  // invalidates the current session
            session = request.getSession(true);  // creates a new session
        } else if (request.isRequestedSessionIdValid() && !request.isRequestedSessionIdFromURL()) {
            HttpSession session = request.getSession();
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            request.login(userName, password);
        }
    }
}