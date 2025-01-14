import java.io.IOException;

public class ExampleServlet {

    public void handleRequests(HttpServletResponse response) throws IOException {
        // 1. Incorrectly formed query
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request

        // 2. Correctly formed query refers to a resource which does not exist
        response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found

        // 3. Resource successfully deleted
        response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204 No Content

        // 4. Resource successfully edited
        response.setStatus(HttpServletResponse.SC_OK); // 200 OK or
        // response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204 No Content if no body is sent back
    }

    // Minimal interface for HttpServletResponse to make the code executable
    public interface HttpServletResponse {
        int SC_BAD_REQUEST = 400;
        int SC_NOT_FOUND = 404;
        int SC_NO_CONTENT = 204;
        int SC_OK = 200;

        void setStatus(int sc);
    }
}