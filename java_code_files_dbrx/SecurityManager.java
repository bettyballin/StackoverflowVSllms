import java.lang.String;

public class SecurityManager {
    boolean userNotLoggedIn = true;
    Request request = new Request();
    Request req = new Request();

    {
        if (userNotLoggedIn) {
            request.setAttribute("requestedUrl", req.getRequestURL().toString());
        }
    }

    public static void main(String[] args) {
    }

    class Request {
        public void setAttribute(String name, Object value) {
            // Implementation
        }

        public URL getRequestURL() {
            return new URL();
        }
    }

    class URL {
        public String toString() {
            return "http://example.com";
        }
    }
}