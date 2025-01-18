import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ServerStartTimeContextListener extends HttpServlet {
    long serverStartTime = System.currentTimeMillis(); // Time when users started the test

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletConfig().getServletContext();
        context.setAttribute("servletStartTime", serverStartTime);
    }

    public static void main(String[] args) {
    }
}