import java.lang.String;
import java.io.*;
import java.net.*;

public class Client_2 {
    public static void main(String[] args) throws IOException {
        // Initialize a connection to the server on localhost at port 12345
        Socket clientSocket = new Socket("localhost", 12345);
        System.out.println("Connected to server: " + clientSocket.getInetAddress());

        // Read the float from the socket input stream as bytes and convert it back to a float
        try (DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream())) {
            float receivedFloatValue = inFromServer.readFloat();
            System.out.println("Received floating point value: " + receivedFloatValue);
        }

        // Close the client socket
        clientSocket.close();
    }
}