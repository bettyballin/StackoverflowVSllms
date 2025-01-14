import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContentController extends HttpServlet {
    // In your servlet or controller
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("content", new Content("Insert Title Here", "Insert Body Here"));
        req.getRequestDispatcher("/base.jsp?includeContent=/WEB-INF/content.jsp").forward(req, resp);
    }
    public static void main(String[] args) {
    }
}