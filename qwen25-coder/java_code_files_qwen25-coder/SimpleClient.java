import java.lang.String;
import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 54321);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Send data
        out.println("Hello, server!");

        // Close connection after sending
        out.close();
        clientSocket.close();
    }
}