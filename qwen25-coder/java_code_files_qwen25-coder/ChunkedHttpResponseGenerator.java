import java.lang.String;
import java.lang.Integer;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.IOException;

public class ChunkedHttpResponseGenerator {

    public static void main(String[] args) throws IOException {
        String chunk1 = "Hello";
        String chunk2 = " world!";
        String endOfChunksMarker = "0\r\n\r\n";

        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                              "Transfer-Encoding: chunked\r\n" +
                              "\r\n" +
                              Integer.toHexString(chunk1.length()) + "\r\n" + chunk1 + "\r\n" +
                              Integer.toHexString(chunk2.length()) + "\r\n" + chunk2 + "\r\n" +
                              endOfChunksMarker;

        // Convert the string to bytes
        byte[] responseBytes = httpResponse.getBytes(StandardCharsets.UTF_8);

        // Send the bytes over a socket or output stream
        OutputStream outputStream = System.out; // Replace with your actual output stream
        outputStream.write(responseBytes);
    }
}