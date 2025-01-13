import java.lang.String;

public class HttpRequestProcessor {
    public static void main(String[] args) {
        // You need an instance of the class to access non-static variables
        HttpRequestProcessor processor = new HttpRequestProcessor();
        // You need to define or pass the 'request' object to access its methods
        // For demonstration purposes, let's assume 'request' is an instance of HttpServletRequest
        javax.servlet.http.HttpServletRequest request = null; // This needs to be properly initialized
        String hostName = request.getHeader("Host");
    }
}