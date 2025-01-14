import java.lang.String;
import java.io.*;
import java.net.*;

public class OptimizerDaemon {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            System.out.println("Optimizer Daemon started...");
            while (true) {
                Socket socket = listener.accept();
                Thread handlerThread = new Thread(new ClientHandler(socket));
                handlerThread.start();
            }
        } finally {
            listener.close();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        public ClientHandler(Socket socket) { this.socket = socket; }

        @Override
        public void run() {
            try (
                    OutputStream os = socket.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
                    BufferedWriter bw = new BufferedWriter(osw);
                    Process process = runOptimizer();
            ) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                }

            } catch (Exception e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                try { socket.close(); } catch (IOException e) { /* ignore */ }
            }
        }

        private Process runOptimizer() throws IOException {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "/path/to/cplexOptimizer.jar");
            // Add any needed arguments here
            return pb.start();
        }
    }
}