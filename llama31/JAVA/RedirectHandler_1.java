import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedirectHandler_1_1 {
    public void handleRedirect(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String redirectUrl = (String) session.getAttribute("redirectUrl");
        if (redirectUrl != null) {
            try {
                response.sendRedirect(redirectUrl);
            } catch (Exception e) {
                // handle exception
            }
        } else {
            // default dashboard URL
            try {
                response.sendRedirect("/dashboard");
            } catch (Exception e) {
                // handle exception
            }
        }
    }

    public static void main(String[] args) {
        // This main method is not used in this servlet-like class
        // and should be removed in a real-world application.
        // For demonstration purposes only.
    }
}