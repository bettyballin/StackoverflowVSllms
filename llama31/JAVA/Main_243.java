import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpExchange;

public class Main_243 {
    private HttpExchange httpExchange;

    public void sendFile(String file, String uri) {
        try {
            File requestedFile = new File(file);
            OutputStream out = this.getHttpExchange().getResponseBody();

            // Set the correct MIME type for the image
            String mimeType = getMimeType(requestedFile.getName());
            this.getHttpExchange().getResponseHeaders().set("Content-Type", mimeType);

            // Send the image data
            InputStream in = new FileInputStream(requestedFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
            out.close();
            System.out.println("FILE " + uri + " SEND!");
        } catch (Exception e) {
            // catch it ...
        }
    }

    // Helper method to get the MIME type for a file
    private String getMimeType(String fileName) {
        // You can use a library like Apache Tika to determine the MIME type
        // or use a simple approach like this:
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (fileName.endsWith(".png")) {
            return "image/png";
        } else {
            return "application/octet-stream"; // default
        }
    }

    private HttpExchange getHttpExchange() {
        return httpExchange;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.sendFile("path_to_your_file", "uri");
    }
}