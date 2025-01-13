import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// EmbeddedWarServlet.java
@WebServlet("/embedded/*")
public class EmbeddedWarServlet extends HttpServlet {
    private static final String EMBEDDED_WAR = "/WEB-INF/embedded.war";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext embeddedServletContext = getServletContext().getContext(EMBEDDED_WAR);
        RequestDispatcher dispatcher = embeddedServletContext.getRequestDispatcher(req.getPathInfo());
        dispatcher.forward(req, resp);
    }

    public static void main(String[] args) {
    }
}