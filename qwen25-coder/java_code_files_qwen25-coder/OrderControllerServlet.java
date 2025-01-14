import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderControllerServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("ConfirmOrder".equals(action)) {
            // Handle order confirmation logic
            // Perform DB tasks and redirect
            response.sendRedirect("confirmation.jsp");
        } else if ("Cancel".equals(action)) {
            // Redirect to the same page without making changes
            response.sendRedirect(request.getContextPath() + "/yourFormPage.jsp");
        }
    }
    public static void main(String[] args) {
    }
}