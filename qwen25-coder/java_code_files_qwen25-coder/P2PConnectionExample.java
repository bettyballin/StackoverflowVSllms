import java.lang.String;
import java.lang.Integer;
import java.io.*;
import java.net.*;

public class P2PConnectionExample {

    // Method to establish server-mediated connection and exchange addresses
    public void startServerMediatedConnection(String serverAddress) throws IOException {
        Socket serverSocket = new Socket(serverAddress, 12345); // Connect to server on port 12345

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter outToServer = new PrintWriter(serverSocket.getOutputStream(), true);

        // Server sends peer details after establishment of the initial server-mediated connection
        String peerAddress = inFromServer.readLine();
        int peerPort = Integer.parseInt(inFromServer.readLine());

        outToServer.println("Peer details received, attempting direct connection...");

        tryDirectConnection(peerAddress, peerPort);

        serverSocket.close();
    }

    // Method to attempt direct P2P connection using the exchanged information
    private void tryDirectConnection(String address, int port) {
        try (Socket p2pSocket = new Socket(address, port)) {
            System.out.println("Successfully switched to direct P2P connection!");
            
            // Now use p2pSocket for communication
            OutputStream outToPeer = p2pSocket.getOutputStream();
            InputStream inFromPeer = p2pSocket.getInputStream();

            // Send and receive data directly between peers...
        } catch (IOException e) {
            System.err.println("Failed to establish direct P2P connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            new P2PConnectionExample().startServerMediatedConnection("192.168.1.100");
        } catch (IOException e) {
            System.err.println("Error during server-mediated connection: " + e.getMessage());
        }
    }
}