import java.lang.String;
import com.apple.dnssd.ResolveListener;
import com.apple.dnssd.DNSSDService;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyResolveListener implements ResolveListener {
    public void serviceResolved(DNSSDService resolver, int flags, int ifIndex, String fullName, String hostName, int port, com.apple.dnssd.TXTRecord txtRecord) {
        try {
            InetAddress address = InetAddress.getByName(hostName);
            System.out.println("IP Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error resolving hostname: " + e.getMessage());
        }
    }

    public void operationFailed(DNSSDService service, int errorCode) {
        System.out.println("Error: " + errorCode);
    }

    public static void main(String[] args) {
        // You need to create an instance of DNSSDService and pass it to the listener
        // To make this code executable, you need to have the Bonjour library in your classpath
        // Here's an example of how you can use the MyResolveListener class
        DNSSDService service = DNSSDService.resolve(0, 0, "_http._tcp.local.", new MyResolveListener());
    }
}