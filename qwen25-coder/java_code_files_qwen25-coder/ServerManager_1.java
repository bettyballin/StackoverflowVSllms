import java.util.*;

public class ServerManager_1 {

    private List<ServerObject> servers;

    public ServerManager_1() {
        // Initialize the servers list
        servers = new ArrayList<>();
    }

    public void stopAndRemove(ServerObject server) {
        // Implement stop and remove functionality
    }

    public void closeCurrentlyOpen() {
        synchronized (this.servers) {
            Iterator<ServerObject> iterator = this.servers.iterator();
            while (iterator.hasNext()) {
                ServerObject server = iterator.next();
                stopAndRemove(server);
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
    }
}

class ServerObject {
    // ServerObject implementation
}