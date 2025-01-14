import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ActionHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("Submit1".equals(action)) {
            // Handle Submit1 button click
        } else if ("Submit2".equals(action)) {
            // Handle Submit2 button click
        }
    }
    
    public static void main(String[] args) {
    }
}