import java.io.IOException;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class LongPollingHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            Thread.sleep(5000); // Simulate wait time for server-side processing or data arrival
            String message = "Update from server at " + System.currentTimeMillis();
            exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
            byte[] responseBytes = message.getBytes("UTF-8");
            exchange.sendResponseHeaders(200, responseBytes.length);
            exchange.getResponseBody().write(responseBytes);
            exchange.getResponseBody().close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Main method can be empty or used to start the server
    }
}