import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    public void handleError(HttpServletResponse response, Exception exception) {
        // Log errors securely
        logger.error("Error occurred", exception);

        // Handle errors without revealing sensitive information
        try {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        } catch (IOException e) {
            logger.error("Error sending error response", e);
        }
    }

    public static void main(String[] args) {
        ErrorHandler errorHandler = new ErrorHandler();
        // You would typically call handleError from a servlet or other web application code
        // errorHandler.handleError(response, exception);
    }
}