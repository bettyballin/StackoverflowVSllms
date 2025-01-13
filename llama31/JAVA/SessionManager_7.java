import java.lang.String;
import java.lang.Set;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionManager_7_7 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Set a cookie
        Cookie cookie = new Cookie("username", "john");
        response.addCookie(cookie);

        // Create a session
        HttpSession session = request.getSession();
        session.setAttribute("user", new User("john", "doe"));
    }

    public static void main(String[] args) {
    }
}

class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}