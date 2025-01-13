import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager_1_1 {
    public static void main(String[] args) {
        // This is a placeholder for an HttpServletRequest object
        HttpServletRequest request = null; // You need to get this from a servlet or another source

        // Set the isLogin variable in the session
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);

        // Check the isLogin variable in the session
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        if (isLogin != null && isLogin) {
            // User is logged in
            System.out.println("User is logged in");
        } else {
            System.out.println("User is not logged in");
        }
    }
}