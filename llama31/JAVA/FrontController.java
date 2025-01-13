import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController {
    // In FrontController
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getPathInfo();
        if (path.startsWith("/articles/")) {
            // Handle articles requests
        } else if (path.startsWith("/forum/")) {
            // Handle forum requests
        } else {
            // Handle other requests
        }
    }
    public static void main(String[] args) {
    }
}