import java.lang.String;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class FileTransferServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client...");
        Socket socket = server.accept();
        System.out.println("Client connected");

        File file = new File("/path/to/your/file");
        byte[] bytes = Files.readAllBytes(file.toPath());

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt((int) file.length()); // send the length of the file
        dataOutputStream.write(bytes, 0, (int) file.length()); // send the bytes
    }
}