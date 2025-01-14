import java.io.InputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener_1 {
    public static void main(String[] args) {
        ServerListener_1 x = new ServerListener_1();
        x.initialize();
    }
    
    private void initialize() {
        try (ServerSocket s = new ServerSocket(4448)) {
            System.out.println("Listening for connections on port 4448...");
            while (true) {
                try (Socket clientSocket = s.accept();
                     InputStream is = clientSocket.getInputStream();
                     DataInputStream dis = new DataInputStream(is)) {

                    System.out.println("Accepted connection from: " + clientSocket.getInetAddress());
                    byte input = dis.readByte();
                    System.out.println("Read: " + input);

                } catch (EOFException e) {
                    System.out.println("Client closed the connection.");
                } catch (IOException ex) {
                    System.err.println("IO Exception: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Server exception: " + ex.getMessage());
        }
    }
}