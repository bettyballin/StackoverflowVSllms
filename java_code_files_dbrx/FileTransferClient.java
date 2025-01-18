import java.lang.String;
import java.io.*;
import java.net.Socket;

public class FileTransferClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234); // or use IP address of the server
        System.out.println("Connected");

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int length = dataInputStream.readInt(); // read the file's length
        byte[] bytes = new byte[length];
        dataInputStream.readFully(bytes, 0, bytes.length); // receive the bytes of the file
    }
}