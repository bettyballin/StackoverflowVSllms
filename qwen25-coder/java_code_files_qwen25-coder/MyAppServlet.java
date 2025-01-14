// Example of a simple Servlet
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet("/myapp")
public class MyAppServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyBusinessLogic logic = new MyBusinessLogic();
        String result = logic.getResult();  // Assuming getResult() is your business logic method
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/result.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}