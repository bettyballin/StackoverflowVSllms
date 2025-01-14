import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/invalidateSession")
public class InvalidateSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // This will trigger sessionDestroyed
        }
        
        response.getWriter().println("Session invalidated!");
    }

    public static void main(String[] args) {
    }
}