import java.lang.String;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for client connection...");

            try (Socket socket = serverSocket.accept();
                 BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                 FileOutputStream fos = new FileOutputStream("receivedFile.txt")) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                long totalBytesRead = 0;

                while ((bytesRead = bis.read(buffer)) > -1) {
                    fos.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                }

                System.out.println("File received successfully with " + totalBytesRead + " bytes.");
            }
        }
    }
}