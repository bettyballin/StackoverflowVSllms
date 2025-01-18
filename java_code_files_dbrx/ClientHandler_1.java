import java.lang.String;
import java.net.*;
import java.io.*;

public class ClientHandler_1 implements Runnable {
    private final ServerSocket server;
    public Thread t;

    ClientHandler_1(String ip, int port) throws IOException {
        this.server = new ServerSocket(port);
    }

    @Override
    public void run() {
        while (true){
            try{
                Socket client = server.accept(); // wait for a connection to the VPN
                DataInputStream dataIn = new DataInputStream(client.getInputStream());

                byte[] bytes = new byte[64*1024]; // create an empty buffer of proper size
                int length;

                while ((length = dataIn.read(bytes)) != -1) {
                    processBytes(bytes, length); // handle received data accordingly
                }
            } catch (IOException e){
                System.out.println("Error handling client: " + e);
            }
        }
    }

    public void start() {
        if (t == null) t = new Thread(this, "ClientHandler");
        t.start();
    }

    public void processBytes(byte[] bytes, int length) {
        // Add code to process bytes as needed
    }

    public static void main(String[] args) {
    }
}