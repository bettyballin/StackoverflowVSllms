import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// Added the missing import statement for Thread
import java.lang.Thread;

public class Main_779 {
    public static void main(String[] args) throws IOException {
        // Replace with your actual socket initialization
        Socket socket = new Socket("localhost", 8080);

        // Send periodic "ping" messages
        while (true) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                String message = "ping";
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                Thread.sleep(1000); // wait 1 second
            } catch (IOException | InterruptedException e) {
                System.out.println("Error sending ping: " + e.getMessage());
                break;
            }
        }
    }
}