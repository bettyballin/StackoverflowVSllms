import java.net.MalformedURLException;
import java.net.URL;

public class SelfReferencingURLGenerator {

    public String getSelfReferencingURL(HttpServletRequest request) {
        // Get server name and port from request
        String scheme = request.getScheme();             // "http" or "https"
        String serverName = request.getServerName();     // Hostname of the server (e.g., www.example.com)
        int serverPort = request.getServerPort();        // Port number (80 for HTTP, 443 for HTTPS)

        // Reconstruct URL from these values
        try {
            URL requestURL = new URL(scheme, serverName, serverPort, request.getRequestURI());
            return requestURL.toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to construct self-referencing URL", e);
        }
    }
}

interface HttpServletRequest {
    String getScheme();
    String getServerName();
    int getServerPort();
    String getRequestURI();
}