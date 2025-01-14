import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.UUID;

public class CSRFServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String csrfToken = UUID.randomUUID().toString();
        session.setAttribute("csrfToken", csrfToken);

        // Output the HTML form
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form method=\"post\" action=\"/submit_form\">");
        out.println("<input type=\"hidden\" name=\"csrfToken\" value=\"" + csrfToken + "\"/>");
        // other fields
        out.println("<input type=\"submit\" value=\"Submit\"/>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sessionCSRF = (String) session.getAttribute("csrfToken");
        String requestCSRF = request.getParameter("csrfToken");
        if (sessionCSRF == null || !sessionCSRF.equals(requestCSRF)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF token");
            return;
        }

        // Process the form submission
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Form submitted successfully.");
    }
}