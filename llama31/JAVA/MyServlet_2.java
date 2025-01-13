import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

public class MyServlet_2_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (!path.startsWith("prefix_")) {
            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getNamedDispatcher("default");
            dispatcher.forward(req, resp);
        } else {
            // handle the request as you want
        }
    }

    public static void main(String[] args) {
    }
}