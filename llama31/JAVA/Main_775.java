import java.io.InputStream;
import java.net.Socket;

public class Main_775 {
    public static void main(String[] args) throws Exception {
        // Assuming we have an existing socket connection
        Socket socket = new Socket("localhost", 8080); // Replace with actual host and port
        InputStream in = socket.getInputStream();
        int bytesRead = in.read();
        if (bytesRead == -1) {
            // Remote side socket close detected
            System.out.println("Remote side socket close detected");
        }
        socket.close(); // Close the socket to prevent resource leak
    }
}