import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class SessionManager {
    public static void main(String[] args) {
        HttpServletRequest request = null; // You need to get the request object from somewhere, e.g., a servlet
        HttpSession session = request.getSession();
        session.setAttribute("foo", "bar");
    }
}