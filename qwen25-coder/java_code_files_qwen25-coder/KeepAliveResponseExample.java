import java.lang.String;
public class KeepAliveResponseExample {
    // Example of how an HTTP 1.1 response might include Keep-Alive headers
    String httpResponse = "HTTP/1.1 200 OK\r\n" +
                          "Content-Type: text/html\r\n" +
                          "Connection: keep-alive\r\n" +
                          "Keep-Alive: timeout=5, max=100\r\n" +
                          "\r\n" +
                          "<html><body>Example Response</body></html>";
    public static void main(String[] args) {
    }
}