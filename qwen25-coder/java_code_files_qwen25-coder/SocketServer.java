import java.lang.String;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        int port = 12345; // Example port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    // Handle the client connection here
                    System.out.println("New client connected");

                    // Example: Read data from client, etc.
                    // BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // String line;
                    // while ((line = in.readLine()) != null) {
                    //     System.out.println(line);
                    // }
                } catch (IOException e) {
                    System.err.println("Error handling client connection");
                }
            }
        } catch (IOException ex) {
            System.err.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}