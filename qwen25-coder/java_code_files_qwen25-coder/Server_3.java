import java.lang.String;
import java.io.*;
import java.net.*;

public class Server_3 {
    public static void main(String[] args) throws IOException {
        // Create a server socket to listen for connections on port 12345.
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        // Wait for a client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getInetAddress());

        // Prepare the data to send (floating point number)
        float ret_val = 123.456f;

        // Write the float as bytes to the socket output stream
        try (DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream())) {
            outToClient.writeFloat(ret_val);
        }

        // Close the client socket and server socket
        clientSocket.close();
        serverSocket.close();
    }
}