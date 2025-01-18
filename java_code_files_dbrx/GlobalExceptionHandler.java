import java.lang.String;
import java.io.*;
import javax.servlet.*;
public class GlobalExceptionHandler implements Filter {
     public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException {
         try {
             filterchain.doFilter(servletrequest, servletresponse);  // Allows the request to proceed normally if there is no error.
         } catch (Throwable throwable) {     // Catches all types of exceptions whether runtime or compile-time ones like missing ";".
             RequestDispatcher rd = servletrequest.getRequestDispatcher("/WEB-INF/jspf/error_page");
             // Forward request to error page (or desired location).
             rd.forward(servletrequest, servletresponse);
         }
     }

	public static void main(String[] args) {
	}
}