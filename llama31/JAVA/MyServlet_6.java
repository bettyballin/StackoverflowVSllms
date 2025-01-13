import java.lang.String;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class MyServlet_6_6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        response.getWriter().write("Hello from server!");
    }

    public static void main(String[] args) {
        System.out.println("This is a Servlet and needs to be run within a Servlet container.");
        System.out.println("Compilation test successful. Use a Servlet container like Tomcat to run the Servlet.");
    }
}