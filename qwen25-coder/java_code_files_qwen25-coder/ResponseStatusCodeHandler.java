import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class ResponseStatusCodeHandler {
    HttpServletResponse response;

    // If the resource doesn't exist or the user is not authorized, send:
    public ResponseStatusCodeHandler() {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    public static void main(String[] args) {
    }
}