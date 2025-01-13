import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class MessageReceiver {
    public static void main(String[] args) throws IOException {
        // Assuming a socket object is already created and connected
        Socket socket = new Socket("localhost", 8080); // Replace with actual host and port

        DataInputStream in = new DataInputStream(socket.getInputStream());

        // Read message length (4 bytes)
        byte[] lengthBytes = new byte[4];
        in.readFully(lengthBytes);
        int messageLength = ByteBuffer.wrap(lengthBytes).getInt();

        // Read message data
        byte[] messageBytes = new byte[messageLength];
        in.readFully(messageBytes);

        // Close the socket
        socket.close();
    }
}