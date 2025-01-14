import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionAttributeExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Setting attribute in the session
        if (session.isNew()) { // Check if it's a new session
            session.setAttribute("username", "JohnDoe");
        }
    
        // Getting attribute from the session
        String username = (String) session.getAttribute("username");
    
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Hello, " + username);
        out.println("</body></html>");
    }
    	public static void main(String[] args) {
    	}
}