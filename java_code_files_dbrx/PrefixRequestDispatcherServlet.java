import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrefixRequestDispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestPath = request.getPathInfo();
        if (!requestPath.startsWith("prefix_")) {
            getServletContext().getNamedDispatcher("default").forward(request, response);
            return;
        }

        // Your code for handling "prefix_*" files here...
    }

    public static void main(String[] args) {
    }
}