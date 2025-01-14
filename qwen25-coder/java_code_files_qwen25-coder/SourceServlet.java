import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

// In your first Servlet (SourceServlet.java)
public class SourceServlet extends HttpServlet {
    private static final String _USERNAME_ = "yourUsername"; // Replace with actual username
    private static final String name = "Your Name";          // Replace with actual name
    private static final String _PASSWORD_ = "yourPassword"; // Replace with actual password

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the parameters as request attributes
        request.setAttribute("txtUsername", _USERNAME_);
        request.setAttribute("txtName", name);
        request.setAttribute("txtPassword", _PASSWORD_);

        // Forward to the next JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("targetJSP.jsp");
        dispatcher.forward(request, response);
    }
}