import java.lang.String;
import com.apple.dnssd.*;
import java.net.InetAddress;
import java.io.IOException;

public class BonjourClient implements ResolveListener {

    @Override
    public void serviceResolved(DNSSDService service, int flags, 
                                int ifIndex, String fullName, 
                                String hostTarget, int port, TXTRecord record) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostTarget);
            for (InetAddress address : addresses) {
                System.out.println("IP Address: " + address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void operationFailed(DNSSDService service, int errorCode) {
        System.err.println("Resolve failed: error code " + errorCode);
    }

    public static void main(String[] args) throws Exception {
        final DNSSD b = DNSSD.getInstance();
        b.browse(0, 0, "_http._tcp", new BrowseListener() {
            @Override
            public void serviceFound(DNSSDService browser, int flags, 
                                     int ifIndex, String serviceName, String regType, String domain) 
                                     throws DNSSDException {
                b.resolve(flags, ifIndex, serviceName, regType, domain, new BonjourClient());
            }

            @Override
            public void serviceLost(DNSSDService browser, int flags, 
                                    int ifIndex, String serviceName, String regType, String domain) {
                System.out.println("Service lost: " + serviceName);
            }

            @Override
            public void operationFailed(DNSSDService service, int errorCode) {
                System.err.println("Browse failed: error code " + errorCode);
            }
        });
    }
}