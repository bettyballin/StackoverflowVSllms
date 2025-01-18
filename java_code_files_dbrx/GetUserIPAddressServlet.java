import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetUserIPAddressServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ipAddress = request.getRemoteAddr(); // Get user's IP address.

        // Display the IP Address in a text box (using JSP)
        PrintWriter out = response.getWriter();
        out.println("<input type=\"text\" readonly value=\"" + ipAddress + "\">");
    }

    public static void main(String[] args) {
    }
}