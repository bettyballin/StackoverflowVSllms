import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/example")
public class ExampleServlet_4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Business logic here
        String result = "Hello, world!";
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("example.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}