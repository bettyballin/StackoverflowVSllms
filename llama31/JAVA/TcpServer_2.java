import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer_2_2 {
    public static void main(String[] args) {
        TcpServer_2 x = new TcpServer_2();
        x.initialize();
    }

    private void initialize() {
        ServerSocket s;
        try {
            s = new ServerSocket(4448);
            s.setSoTimeout(0);
            s.setReuseAddress(true);
            while (true) {
                Socket clientSocket = s.accept();
                handleClient(clientSocket);
            }
        } catch (IOException ex) {
            System.out.println("ioexception");
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            InputStream is = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            try {
                byte input = dis.readByte();
                System.out.println("read: " + input);
            } catch (Exception ex) {
                System.out.println("Exception");
            } finally {
                dis.close();
                is.close();
                clientSocket.close();
            }
        } catch (IOException ex) {
            System.out.println("ioexception");
        }
    }
}