import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class method extends HttpServlet {
    // Inside your Servlet class method (e.g., doGet or doPost)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Your servlet logic here...

        // Forward request and response objects to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("yourPage.jsp");
        dispatcher.forward(request, response);
    }
    public static void main(String[] args) {
    }
}