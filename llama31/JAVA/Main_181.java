import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class Main_181 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Assume 'ret_val' is your floating point value
        float ret_val = 3.14f;

        // Convert float to byte array
        byte[] bytes = new byte[4]; // float is 4 bytes long
        ByteBuffer.wrap(bytes).putFloat(ret_val);

        // Send bytes over socket
        String clientIp = "localhost"; // Replace with actual client IP
        int clientPort = 8080; // Replace with actual client port
        Socket socket = new Socket(clientIp, clientPort);
        OutputStream out = socket.getOutputStream();
        out.write(bytes);
        out.flush();

        // Close the socket
        socket.close();
    }
}