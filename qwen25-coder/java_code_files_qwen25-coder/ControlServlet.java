import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // Generate dynamic content
        out.println("<div>Custom control content</div>");
    }

	public static void main(String[] args) {
	}
}