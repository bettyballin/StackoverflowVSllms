import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientSocketConnection {
    public static void main(String[] args) {
        Socket s;
        OutputStream os;
        int counter = 0;

        while (true) {
            try {
                s = new Socket("localhost", 4448);
                System.out.println("Connected to server.");
                os = s.getOutputStream();

                os.write((byte) counter++);
                os.flush();
                
                // Close the streams and socket after each use
                os.close();
                s.close();
                Thread.sleep(100); // Give some time before reconnecting

            } catch (SocketException e) {
                System.err.println("Connection reset by peer: " + e.getMessage());
            } catch (IOException | InterruptedException ex) {
                System.err.println("ERROR: could not connect/reconnect: " + ex.getMessage());
            }
        }
    }
}