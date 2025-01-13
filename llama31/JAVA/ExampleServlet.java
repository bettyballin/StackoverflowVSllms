import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

// Server-side (Java)
@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String token = req.getHeader("X-Token");
        // Store the token with the request
        req.setAttribute("token", token);
        
        // Periodically check if the token has been cancelled
        if (isCancelled(token)) {
            // Stop processing the request
            return;
        }
        
        // Process the request...
    }
    
    private boolean isCancelled(String token) {
        // Check if the token has been cancelled (e.g., stored in a database or cache)
        // Assuming CancelledTokensStore is a custom class with a static method isCancelled
        return CancelledTokensStore.isCancelled(token);
    }

	public static void main(String[] args) {
	}
}