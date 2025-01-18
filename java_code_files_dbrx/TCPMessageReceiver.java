import java.lang.String;
import java.io.*;
import java.net.*;

public class TCPMessageReceiver {
    public TCPMessageReceiver(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        int len = dis.readInt(); // read int (Big Endian) and use it as the length

        // Reading exactly length bytes from input stream to a byte array
        byte[] msgBytes = new byte[len];
        dis.readFully(msgBytes);
    }

    public static void main(String[] args) {
    }
}