import java.lang.String;
import java.io.*;
import java.net.*;

public class ConcurrencyCheck {
    // Enum to represent concurrency models
    public enum ConcurrencyModel { APARTMENT_THREADED, MULTI_THREADED }

    // Server side code
    static class Server extends Thread {
        private final Socket clientSocket;
        private final ConcurrencyModel serverConcurrencyModel;

        public Server(Socket socket, ConcurrencyModel model) {
            this.clientSocket = socket;
            this.serverConcurrencyModel = model;
        }

        @Override
        public void run() {
            try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                // Send server's concurrency model to the client
                out.println(serverConcurrencyModel);

                // Receive client's concurrency model
                ConcurrencyModel clientConcurrencyModel = ConcurrencyModel.valueOf(in.readLine());

                // Check if they match
                if (serverConcurrencyModel == clientConcurrencyModel) {
                    System.out.println("Server and Client are in the same concurrency model: " + serverConcurrencyModel);
                } else {
                    System.out.println("Mismatch in concurrency models!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Client side code
    static class Client {
        private final ConcurrencyModel clientConcurrencyModel;

        public Client(ConcurrencyModel model) {
            this.clientConcurrencyModel = model;
        }

        public void connect(String host, int port) {
            try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                // Receive server's concurrency model
                ConcurrencyModel serverConcurrencyModel = ConcurrencyModel.valueOf(in.readLine());

                // Send client's concurrency model to the server
                out.println(clientConcurrencyModel);

                // Check if they match
                if (serverConcurrencyModel == clientConcurrencyModel) {
                    System.out.println("Server and Client are in the same concurrency model: " + serverConcurrencyModel);
                } else {
                    System.out.println("Mismatch in concurrency models!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        ConcurrencyModel serverConcurrencyModel = ConcurrencyModel.MULTI_THREADED; // Define server's concurrency model

        new Thread(() -> { // Start the Client
            try {
                ConcurrencyModel clientConcurrencyModel = ConcurrencyModel.MULTI_THREADED; // Define client's concurrency model
                new Client(clientConcurrencyModel).connect("127.0.0.1", 9090);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try (
            Socket socket = listener.accept()
        ) {
            new Server(socket, serverConcurrencyModel).start(); // Accept and handle the client connection
        } finally {
            listener.close();
        }
    }
}