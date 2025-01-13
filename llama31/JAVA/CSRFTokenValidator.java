import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CSRFTokenValidator {
    public boolean isValid(HttpServletRequest request) {
        String csrfToken = request.getParameter("csrfToken");
        String expectedToken = (String) request.getSession().getAttribute("CSRF_TOKEN");
        
        return csrfToken != null && csrfToken.equals(expectedToken);
    }

    public static void main(String[] args) {
    }
}