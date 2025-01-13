import java.io.OutputStream;
import java.net.Socket;

public class Main_79 {
    public static void main(String[] args) throws Exception {
        byte[] chokeMessage = new byte[] { 0x00, 0x00, 0x00, 0x01, 0x00 }; // <len=0001><id=0>
        Socket socket = new Socket("localhost", 8080); // replace with actual host and port
        OutputStream out = socket.getOutputStream();
        out.write(chokeMessage);
        out.close();
        socket.close();
    }
}