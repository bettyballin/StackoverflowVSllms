import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class FileResponseHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            // Get the request URI
            String uri = exchange.getRequestURI().toString();

            // Assume 'file' is obtained from the URI
            String file = uri.substring(1); // Remove leading '/' if any

            File requestedFile = new File(file);

            OutputStream out = exchange.getResponseBody();

            // Set the content type header for images (adjust based on image type)
            String contentType = URLConnection.guessContentTypeFromName(requestedFile.getName());
            if (contentType == null) {
                contentType = "application/octet-stream";  // Default fallback
            }
            exchange.getResponseHeaders().add("Content-Type", contentType);
        
            // Send the HTTP response code and headers
            exchange.sendResponseHeaders(200, requestedFile.length());
        
            // File is sent:
            InputStream in = new FileInputStream(requestedFile);
            byte[] content = new byte[(int) requestedFile.length()];
            in.read(content);

            try {
                out.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            }

            in.close();
            out.close();

            System.out.println("FILE " + uri + " SENT!");
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}