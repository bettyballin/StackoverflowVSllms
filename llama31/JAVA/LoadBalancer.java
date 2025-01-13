import java.util.List;
import java.util.ArrayList;

// Define a simple Server class for demonstration purposes
class Server {
    private String name;

    public Server(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Example of load balancing
public class LoadBalancer {
    private List<Server> servers;
    private int currentServerIndex = 0; // Keep track of the current server index

    public LoadBalancer(List<Server> servers) {
        this.servers = servers;
    }

    public Server getAvailableServer() {
        // Simple round-robin load balancing implementation
        Server server = servers.get(currentServerIndex);
        currentServerIndex = (currentServerIndex + 1) % servers.size();
        return server;
    }

    public static void main(String[] args) {
        // Create a list of servers
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("Server 1"));
        servers.add(new Server("Server 2"));
        servers.add(new Server("Server 3"));

        // Create a load balancer with the list of servers
        LoadBalancer loadBalancer = new LoadBalancer(servers);

        // Demonstrate load balancing by retrieving available servers
        for (int i = 0; i < 7; i++) {
            Server availableServer = loadBalancer.getAvailableServer();
            System.out.println("Available server: " + availableServer.getName());
        }
    }
}