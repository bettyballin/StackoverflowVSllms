import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class Main_180 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Replace "server_ip" with the actual IP address of your server
        // and server_port with the actual port number your server listens on.
        String serverIp = "127.0.0.1"; // Example: "192.168.1.100"
        int serverPort = 12345; // Example port, replace with your server's port

        // Establish a socket connection to the server
        Socket socket = new Socket(serverIp, serverPort);
        
        // Get the input stream to receive data from the server
        InputStream in = socket.getInputStream();
        
        // Buffer to hold the incoming data
        byte[] bytes = new byte[4];
        
        // Read the data from the input stream
        in.read(bytes);

        // Convert the byte array to a float
        float ret_val = ByteBuffer.wrap(bytes).getFloat();

        // Print the received float value
        System.out.println(ret_val);

        // Good practice: Close the socket after use
        socket.close();
    }
}