import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// In your servlet or service implementation
public class ContactDataServiceServlet extends HttpServlet {
    // ...
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.isNew()) {
            // Session has expired, return an error response
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Session expired");
            return;
        }
        // Process the request as usual
        // ...
    }

	public static void main(String[] args) {
	}
}