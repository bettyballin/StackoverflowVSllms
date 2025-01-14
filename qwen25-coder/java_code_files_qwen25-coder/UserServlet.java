import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "John Doe");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/yourJspPage.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}