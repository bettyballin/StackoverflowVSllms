import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHandler {
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            String rustext = request.getParameter("rustext");
            // Add your logic here
        } catch (Exception e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
        // This main method is not used in a typical Servlet application
    }
}