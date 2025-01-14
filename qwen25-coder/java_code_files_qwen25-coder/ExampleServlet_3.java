import java.lang.String;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/example")
public class ExampleServlet_3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String messageFromFilter = (String) context.getAttribute("sharedMessage");

        // Use the retrieved message
        if (messageFromFilter != null) {
            System.out.println("Received message: " + messageFromFilter);
            response.getWriter().write("Received message: " + messageFromFilter);
        } else {
            response.getWriter().write("No message received.");
        }
    }

    public static void main(String[] args) {
    }
}