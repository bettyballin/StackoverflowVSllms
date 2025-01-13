import java.io.InputStream;
import java.io.IOException;
import java.net.Socket;

public class Main_776 {
    public static void main(String[] args) {
        Socket socket = null; // Initialize socket
        try {
            // Establish a socket connection
            socket = new Socket("localhost", 8080); // Replace with the actual host and port you want to connect to
            InputStream in = socket.getInputStream();
            in.read();
        } catch (IOException e) {
            // Handle IOException
            System.out.println("An I/O error occurred: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Failed to close the socket: " + e.getMessage());
                }
            }
        }
    }
}