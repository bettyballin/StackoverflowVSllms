import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Your database query...
        ArrayList<String> reports = new ArrayList<>();
        // ...
        request.setAttribute("reports", reports); // Stores the result list in request scope
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}