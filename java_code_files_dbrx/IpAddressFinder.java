import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressFinder {
    String ipAddress;

    public IpAddressFinder() throws UnknownHostException {
        ipAddress = InetAddress.getByName("hostname").getHostAddress();
        System.out.println("IP Address is " + ipAddress);
    }

    public static void main(String[] args) throws UnknownHostException {
        new IpAddressFinder();
    }
}