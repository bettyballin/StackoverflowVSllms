import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class MainClass {
    public static void main(String[] args) throws IOException {
        // Create empty byte array for zero byte payload of choke message and one byte for length of the message - 4 bytes (1 + 0)
        byte[] payload = new byte[0];
        int id = 0; // Choke message ID is 0
        byte[] len = ByteBuffer.allocate(4).putInt(payload.length).array(); // Length of the choke message payload in big endian format
        DataOutputStream out = new DataOutputStream(getSocket().getOutputStream());
        out.write(len); // Writing length first
        out.writeByte(id); // Then writing ID which is 0 for choke
    }

    private static Socket getSocket() throws IOException {
        // For the purpose of this example, we will create a socket connected to localhost on port 8080
        // In practice, getSocket() would return an existing connected socket
        return new Socket("localhost", 8080);
    }
}