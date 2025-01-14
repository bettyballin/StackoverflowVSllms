import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;
import javax.servlet.ServletException;

public class CookieUtil extends HttpServlet {
    // Inside your servlet method
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie myCookie = new Cookie("myParameter", "myValue");
        myCookie.setMaxAge(3600); // 1 hour lifespan
        response.addCookie(myCookie);
    }
    
    public static void main(String[] args) {
    }
}