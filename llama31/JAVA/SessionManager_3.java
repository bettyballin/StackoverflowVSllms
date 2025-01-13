import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionManager_3_3 {
    public static void main(String[] args) {
        // This code won't work without a HttpServletRequest object
        // HttpSession session = request.getSession();
        // session.setMaxInactiveInterval(30 * 60); // 30 minutes

        // HttpSession session = request.getSession();
        // session.invalidate();
    }
}