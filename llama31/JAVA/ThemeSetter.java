import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class ThemeSetter {
    public void setTheme(HttpSession session, HttpServletRequest request) {
        // Set the theme in the session
        session.setAttribute("theme", request.getParameter("theme"));
    }

    public static void main(String[] args) {
        // This main method is not doing anything, you might want to remove it or use it for testing
    }
}