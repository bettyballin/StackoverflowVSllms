import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ServletRedirector extends HttpServlet {
    // Using sendRedirect
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("anotherServlet");
        
        // Using requestDispatch (forward)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/anotherServlet");
        dispatcher.forward(request, response);
    }
    
    public static void main(String[] args) {
    }
}