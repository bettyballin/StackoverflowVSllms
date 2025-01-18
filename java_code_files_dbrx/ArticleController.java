import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ArticleController", urlPatterns = {"/article/*"})
public class ArticleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/" + request.getRequestURI() + ".jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        if (dispatcher == null) { // no such jsp file existed
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
            return;
        }
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}