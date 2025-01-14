import java.util.HashMap;
import java.util.Map;

public class UserRequestHandler {
    private DnsResolver dnsResolver;

    public UserRequestHandler(DnsResolver resolver) {
        this.dnsResolver = resolver;
    }

    public void handleRequest(String userIp) {
        String userRegion = getUserRegion(userIp); // Fetch region info based on IP, not shown here
        String closestServer = dnsResolver.getClosestServer(userRegion);
        System.out.println("Routing request to: " + closestServer);
        
        // Forward the request to the closest server
    }

    private String getUserRegion(String userIp) {
        // This is a placeholder for functionality that determines region from IP
        return "US"; // Assume all users are in US as an example
    }

    public static void main(String[] args) {
        DnsResolver resolver = new DnsResolver();
        UserRequestHandler handler = new UserRequestHandler(resolver);

        String userIpExample = "123.45.67.89";
        handler.handleRequest(userIpExample);
    }
}

class DnsResolver {
    private Map<String, String> regionToServerMap = new HashMap<>();

    public DnsResolver() {
        // Example setup
        regionToServerMap.put("US", "server1.yourcompany.com");
        regionToServerMap.put("Europe", "server2.yourcompany.com");
        regionToServerMap.put("Asia", "server3.yourcompany.com");
        regionToServerMap.put("Latin America", "server4.yourcompany.com");
    }

    public String getClosestServer(String userRegion) {
        // This should be replaced with actual DNS response with appropriate TTL
        return regionToServerMap.getOrDefault(userRegion, "default.server.com");
    }
}