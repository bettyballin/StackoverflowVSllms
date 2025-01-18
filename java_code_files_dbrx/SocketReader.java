import java.net.Socket;
import java.net.ConnectException;
import java.io.IOException;

public class SocketReader {
    public static void main(String[] args) throws IOException {
        try {
            String host = "localhost";
            int port = 80;
            Socket s = new Socket(host, port); //create your socket here
            byte[] buf = new byte[1];
            while (true) {
                if (s.getInputStream().read(buf) == -1) {  //if the server has closed the connection
                    System.out.println("connection is closed.");
                    break;
                } else {
                    System.out.print("The data received: " + new String(buf));
                }
            }
        } catch (ConnectException e) {
           //handle exceptions as needed here
        }
    }
}