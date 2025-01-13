import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class MyServlet_18 extends HttpServlet {
    @Override
    public void doGet(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    }
}