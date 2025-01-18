import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TcpClient {
    // Sample code for TCP connection (Client)
    Socket socket;
    PrintWriter out;
    BufferedReader in;

    public TcpClient() {
        try {
            socket = new Socket("localhost", 8000);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}