import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DisplayParam1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param1 = request.getParameter("param1");
        response.setContentType("text/html");
        response.getWriter().println("<p>The value of param1 is: " + param1 + "</p>");
    }
}