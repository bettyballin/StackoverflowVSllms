import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private ArrayList<PlayerHandler> players;

    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        players = new ArrayList<>();
    }

    public void start() throws IOException {
        System.out.println("Server started on port " + server.getLocalPort());

        while (true) {
            socket = server.accept();
            System.out.println("A new player has joined the server.");
            PlayerHandler player = new PlayerHandler(socket);
            players.add(player);
            player.start();
        }
    }

    private class PlayerHandler extends Thread {
        private Socket socket;
        private ObjectOutputStream out;

        public PlayerHandler(Socket socket) throws IOException {
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
        }

        public void run() {
            // Handle player-specific logic here
        }

        public void sendData(String data) throws IOException {
            out.writeObject(data);
            out.flush();
        }
    }

    public void sendDataToAll(String data) throws IOException {
        for (PlayerHandler player : players) {
            player.sendData(data);
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(8000); // Choose a port number
            server.start();
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }
}