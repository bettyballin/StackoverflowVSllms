import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProxyDetectionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isProxy = false;

        String[] proxyHeaders = {
                "VIA",
                "X-FORWARDED-FOR",
                "FORWARDED-FOR",
                "X-FORWARDED",
                "FORWARDED",
                "CLIENT-IP",
                "FORWARDED-FOR-IP"
        };

        for (String header : proxyHeaders) {
            if (request.getHeader(header) != null) {
                isProxy = true;
                break; // Proxy detected
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (isProxy) {
            out.println("<html><body>Proxy detected!</body></html>");
        } else {
            out.println("<html><body>No proxy detected.</body></html>");
        }
    }

    public static void main(String[] args) {
    }
}