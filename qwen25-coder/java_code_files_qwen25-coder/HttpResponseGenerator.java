import java.io.OutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpResponseGenerator {
    public static void main(String[] args) throws IOException {
        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                              "Content-Length: 38\r\n" +
                              "Connection: close\r\n" +
                              "\r\n" +
                              "<html><body>Hello, world!</body></html>";

        // Convert the string to bytes
        byte[] responseBytes = httpResponse.getBytes(StandardCharsets.UTF_8);

        // Send the bytes over a socket or output stream
        OutputStream outputStream = System.out; // Replace with your actual output stream
        outputStream.write(responseBytes);
        outputStream.flush();
    }
}