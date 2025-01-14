import java.lang.String;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            // Handle registration
            System.out.println("Register button was clicked");
        } else if ("cancel".equals(action)) {
            // Handle cancel action or redirect to another page
            System.out.println("Cancel button was clicked");
        }
    }

	public static void main(String[] args) {
	}
}