import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SetSecureCookie extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie myCookie = new Cookie("name", "value");
        myCookie.setHttpOnly(true);
        response.addCookie(myCookie);
    }

    public static void main(String[] args) {
        // Main method can be left empty or used for testing
    }
}