import java.lang.String;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDisconnectSimulator {

    public static void simulateServerSideClose() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                // Simulate a disconnection by closing the socket
                clientSocket.close();
                System.out.println("Disconnected client from server.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void simulateClientSideClose() throws IOException {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");
            // Simulate a disconnection by closing the socket
            socket.close();
            System.out.println("Disconnected from server.");
        }
    }

    public static void main(String[] args) throws IOException {
        Thread serverThread = new Thread(SocketDisconnectSimulator::simulateServerSideClose);
        serverThread.start();

        try {
            // Wait a bit for the server to start
            Thread.sleep(1000);
            simulateClientSideClose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}