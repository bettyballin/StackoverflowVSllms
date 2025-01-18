import java.lang.String;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class ErrorHandlingServlet {
    HttpServletResponse httpResp = null; // injected in JSP by server container, can also be obtained from Filters, Servlet or custom written HttpServlet class...
    private static final Logger log = Logger.getLogger(ErrorHandlingServlet.class);

    public ErrorHandlingServlet() {
        try {
            httpResp.setStatus(200); // status code of OK response
            /* do something here */
        } catch (Exception ex) {
            log.error("Error occurred:", ex);

            if (!httpResp.isCommitted()) {
                httpResp.sendRedirect("/errorpage"); // or set your custom error page.
            }
        } finally {
            try {
                /* close any resources, etc */
            } catch (Exception x) {
                // Handle exception
            }
        }
    }

    public static void main(String[] args) {
    }
}