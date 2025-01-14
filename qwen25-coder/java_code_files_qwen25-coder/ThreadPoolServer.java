import java.lang.String;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(20); // Adjust pool size as needed
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    // Process input and send response
                    out.println("Echo: " + inputLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}