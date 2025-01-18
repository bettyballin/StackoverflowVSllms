import java.lang.String;
import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.net.HttpURLConnection;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Headers;

public class FileResponderorHttpResponseSenderwouldbesuitableclassnamesforthisJavacode {

    public void sendFileResponse() {
        String file = "path/to/file";  // Define the file path
        HttpExchange exchange = null;  // Define the HttpExchange object
        InputStream in = null;
        OutputStream out = null;
        try {
            File requestedFile = new File(file);
            out = exchange.getResponseBody(); // Get output stream from HttpExchange

            if (requestedFile != null && requestedFile.exists()) {
                int fileLength = (int) requestedFile.length();
                HttpURLConnection.setFollowRedirects(true);

                exchange.getResponseHeaders().add("Content-type", Files.probeContentType(requestedFile.toPath()));
                exchange.sendResponseHeaders(200, fileLength); // Send headers as per HTTP protocol

                in = new FileInputStream(requestedFile);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) > 0) { // Copy bytes from input to output stream
                    out.write(buffer, 0, len);
                }
            } else {
                System.out.println("file " + file + " not found!");
            }
        } catch (Exception e) {
            // Handle exceptions here
        } finally {
            if (in != null) try { in.close(); } catch (IOException ignored) {}
            if (out != null) try { out.close(); } catch (IOException ignored) {}
        }
    }

    public static void main(String[] args) {
        new FileResponderorHttpResponseSenderwouldbesuitableclassnamesforthisJavacode().sendFileResponse();
    }
}