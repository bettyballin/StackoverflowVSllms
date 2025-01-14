// HeartbeatServer.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Example of simple heartbeat mechanism in Java
public class HeartbeatServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        try (Socket clientSocket = serverSocket.accept()) {
            BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                outputToClient.println("HEARTBEAT");
                String response = inputFromClient.readLine();
                if (!"ACK".equals(response)) {
                    // Handle lost heartbeat
                    System.out.println("No response from client. Closing connection.");
                    break;
                }
                Thread.sleep(20000); // Wait 20 seconds before next heartbeat
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}