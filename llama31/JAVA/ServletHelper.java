import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletHelper {
    public static void main(String[] args) {
    }

    public void includeServlet(ServletRequest request, ServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/servletName");
        dispatcher.include(request, response);
    }
}