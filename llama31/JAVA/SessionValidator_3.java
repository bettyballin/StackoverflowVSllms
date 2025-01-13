import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionValidator_3_3 {
    public static void main(String[] args) {
        HttpServletRequest request = null; // You need to get the request object from somewhere
        HttpSession session = request.getSession(false);
        if (session == null || !session.isValid()) {
            // session is invalid
            System.out.println("Session is invalid");
        }
    }
}