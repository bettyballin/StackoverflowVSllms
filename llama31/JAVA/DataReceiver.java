import java.io.InputStream;
import java.io.IOException;
import java.net.URLConnection;

public class DataReceiver {
    public static void main(String[] args) throws Exception {
        URLConnection connection = null; // Initialize with a valid connection
        InputStream in = connection.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            // Process the received data, ignoring chunk boundaries
            processReceivedData(buffer, bytesRead);
        }
    }

    private static void processReceivedData(byte[] buffer, int bytesRead) {
        // Implement your logic to process the received data
        System.out.println("Received " + bytesRead + " bytes");
    }
}