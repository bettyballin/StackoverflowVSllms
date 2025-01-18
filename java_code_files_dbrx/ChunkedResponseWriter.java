import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChunkedResponseWriter {

    private int totalNumberOfChunks = 10;

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set headers for chunked transfer encoding
        response.setHeader("Transfer-Encoding", "chunked");
        response.flushBuffer();

        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(response.getOutputStream()))) {
            // Write your HTML content in pieces/chunks
            for (int i = 0; i < totalNumberOfChunks; i++) {
                // Send a chunk of data to client
                ByteBuffer buf = getNextChunk();  // This is where you write or read your chunks of data from
                writer.print("" + HexUtils.toHexString(buf) + "\r\n");   // hexadecimal length of each piece in ascii form
                writer.write(Charset.forName("UTF-8").decode(buf).toString());  // write your data chunk into buffered output stream
                writer.print("\r\n");    // delimiter between chunks
                writer.flush();         // Flush out contents of buffer to client
                waitForNextChunk();     // Wait for a second
            }
            writer.write("0\r\n\r\n");   // Signal end of chunked content with "0" and delimiter
        } catch (Exception e) {
            logError(e);
        } finally {
            try {
                response.getOutputStream().close();
            } catch (java.io.IOException ignore) {}
        }
    }

    private ByteBuffer getNextChunk() {
        // For demonstration, return a ByteBuffer with some test data
        String chunkData = "Test data chunk";
        return ByteBuffer.wrap(chunkData.getBytes(Charset.forName("UTF-8")));
    }

    private void waitForNextChunk() {
        // Wait for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void logError(Exception e) {
        e.printStackTrace();
    }

    public static void main(String[] args) {
        // Main method remains empty
    }
}

class HexUtils {
    public static String toHexString(ByteBuffer buf) {
        StringBuilder sb = new StringBuilder();
        for (int i = buf.position(); i < buf.limit(); i++) {
            sb.append(String.format("%02x", buf.get(i)));
        }
        return sb.toString();
    }
}