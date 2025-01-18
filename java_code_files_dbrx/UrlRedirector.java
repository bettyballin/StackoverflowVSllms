import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlRedirector {

    public void redirect(HttpServletRequest request, HttpServletResponse response) {
        if(request.getParameter("forwardUrl") != null) {
            // Redirect or forward based on your needs/architecture. Example for redirects:
            response.sendRedirect("/corporate" + request.getParameter("forwardUrl").substring(request.getContextPath().length()));
        } else {
            // Regular logic to go to the dashboard after successful login
        }
    }

    public static void main(String[] args) {
    }
}