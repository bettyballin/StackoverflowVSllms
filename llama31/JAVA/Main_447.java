import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main_447 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("example.com");
            Socket socket = new Socket(address, 80);
            // Your code here
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}