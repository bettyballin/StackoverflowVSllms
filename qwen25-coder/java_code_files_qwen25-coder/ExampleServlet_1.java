import java.lang.String;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ExampleServlet_1 extends HttpServlet {
    // ExampleServlet.java
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Your risky logic here

            RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("exception", e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    public static void main(String[] args) {
    }
}