import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.net.*;

public class MasterServer {
    private Map<String, List<Socket>> layoutToSlaves = new HashMap<>();

    public static void main(String[] args) throws IOException {
        MasterServer server = new MasterServer();
        ServerSocket masterServerSocket = new ServerSocket(9000);
        // Assuming layoutToSlaves is populated with connected slave servers
        while (true) {
            Socket clientSocket = masterServerSocket.accept();
            new Thread(server.new ClientHandler(clientSocket)).start();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket client;
        
        public ClientHandler(Socket clientSocket) {
            this.client = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(
                     client.getOutputStream(), true)) {

                String layoutRequest = in.readLine();
                // Find an available slave server for the requested layout
                Socket slave = findAvailableSlave(layoutRequest);
                
                if (slave != null) {
                    // Forward client request to slave
                    forwardRequestToSlave(in, out, slave);
                } else {
                    out.println("No available servers for this layout.");
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private Socket findAvailableSlave(String layout) {
            // Logic to find and return an available slave server
            return null;
        }

        private void forwardRequestToSlave(BufferedReader in, PrintWriter masterOut, Socket slave) throws IOException {
            try (
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(slave.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(slave.getInputStream()))
            ) {
                // Forward request from client to slave
                writer.write(in.readLine());
                writer.newLine();
                writer.flush();

                String responseFromSlave;
                while ((responseFromSlave = reader.readLine()) != null) {
                    masterOut.println(responseFromSlave);
                }
                // Notify server that this connection is over and the slave can now accept another request
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}