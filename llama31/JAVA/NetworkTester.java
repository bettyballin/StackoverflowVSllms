import java.lang.String;
import java.net.Socket;
import java.io.OutputStream;

public class NetworkTester {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        OutputStream out = socket.getOutputStream();
        out.write("Hello, server!".getBytes());
        out.close();
        socket.close();
    }
}