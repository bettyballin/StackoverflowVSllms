import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
    private static final List<Socket> clients = new ArrayList<>();
    private Socket clientSocket;

    public Server(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        synchronized (clients) {
            clients.add(clientSocket);
            System.out.println("Player joined. Total players: " + clients.size());
        }
        
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                // You can process the input data here
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            synchronized (clients) {
                clients.remove(clientSocket);  // Remove the client when done
                System.out.println("Player left. Total players: " + clients.size());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4000);
        System.out.println("Server started on port 4000");

        while (true) {
            Socket clientSocket = server.accept();
            new Server(clientSocket).start();  // Each client runs in a separate thread
        }
    }

    public static void broadcastMessage(String message) throws IOException {
        synchronized (clients) {  // Ensure no modifications to clients list while iterating
            for (Socket socket : clients) {
                if (!socket.isClosed()) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(message);  // Send the same message to all clients
                }
            }
        }
    }
}