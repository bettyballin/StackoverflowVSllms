import java.lang.String;
import java.io.InputStream;
import java.net.Socket;

public class SocketCloseDetector {
    public static void main(String[] args) {
        try (Socket socket = new Socket("example.com", 80)) {
            InputStream inputStream = socket.getInputStream();

            // Try to read from the input stream
            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
                System.out.print((char) bytesRead);
            }

            // If we reach here, it means the remote side has closed its connection
            System.out.println("Connection closed by remote host.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}