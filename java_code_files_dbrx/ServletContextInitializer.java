import java.lang.String;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.GenericServlet;

public class ServletContextInitializer extends GenericServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Always remember to call the super constructor first!
        ServletContext application = config.getServletContext();
    }
    public static void main(String[] args) {
    }
}