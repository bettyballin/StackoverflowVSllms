import java.io.UnsupportedEncodingException;

public class HttpServletResponseSender {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String response = "Hello, World!";
        byte[] responseBody = response.getBytes("UTF-8");
        int contentLength = responseBody.length;

        // Send the response headers, including the Content-Length header
        String headers = "HTTP/1.1 200 OK\r\nContent-Length: " + contentLength + "\r\n\r\n";
        byte[] headerBytes = headers.getBytes("UTF-8");

        // Send the response body
        // ... (you would typically use a OutputStream or PrintWriter here)

        // No concluding bytes needed, as the Content-Length header specifies the exact length
    }
}