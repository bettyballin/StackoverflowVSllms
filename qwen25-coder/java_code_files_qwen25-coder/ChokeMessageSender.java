import java.io.DataOutputStream;
import java.net.Socket;

public class ChokeMessageSender {
    public void sendChokeMessage(Socket socket) throws Exception {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // Length of the message (1 byte)
        dos.writeInt(0x00000001);  // This writes the length as a 4-byte big-endian integer
        // Message ID for choke (0)
        dos.writeByte(0);
        dos.flush();  // Ensure it sends immediately
    }
}