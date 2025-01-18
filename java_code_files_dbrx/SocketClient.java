import java.lang.String;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SocketClient {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    {
        try {
            socket = new Socket("localhost", 80); // Connecting using TCP/IP on same device for example purposes only.
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Hello Server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}