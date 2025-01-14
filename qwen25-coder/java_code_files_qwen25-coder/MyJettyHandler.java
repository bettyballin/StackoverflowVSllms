import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class MyJettyHandler extends AbstractHandler {
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        // Set the content type without a charset
        response.setContentType("application/json");  // Change to your desired media type

        // Write your response body here
        response.getWriter().write("{\"message\": \"Hello, world!\"}");

        // Indicate that we handled the request
        response.setStatus(HttpServletResponse.SC_OK);

        // Mark the request as handled
        baseRequest.setHandled(true);
    }

    public static void main(String[] args) {
        // You can add code here to start a Jetty server and set this handler
    }
}