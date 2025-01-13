import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ArtsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/articles/main.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
        // This main method is not used in a typical Java Servlet application
        // The entry point is usually the doGet or doPost method
    }
}