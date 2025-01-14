import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class IE6RedirectHandler extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null && userAgent.contains("MSIE 6.0")) {
            // For IE6, use meta refresh or JavaScript
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<meta http-equiv='refresh' content='0;url=http://yourdomain.com/'>");
            out.println("</head><body>");
            out.println("<script language='javascript'>");
            out.println("window.location.href='http://yourdomain.com/';");
            out.println("</script>");
            out.println("</body></html>");
        } else {
            // For other browsers, use HTTP 302 redirect
            response.sendRedirect("http://yourdomain.com/");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    public static void main(String[] args) {
        // Main method can be left empty or used for testing purposes
    }
}