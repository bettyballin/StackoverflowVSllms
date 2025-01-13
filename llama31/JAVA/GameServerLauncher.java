import java.lang.String;

public class GameServerLauncher {
    public static void main(String[] args) {
        Server server = new Server(8080);
        server.start();

        // Later, when you want to send data to all players
        server.sendDataToAll("Hello, players!");
    }
}

class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Server started on port " + port);
    }

    public void sendDataToAll(String message) {
        System.out.println("Sending message to all players: " + message);
    }
}