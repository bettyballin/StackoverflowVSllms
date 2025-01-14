import java.util.concurrent.CopyOnWriteArrayList;

public class ServerManager {
    private final CopyOnWriteArrayList<ServerObject> servers = new CopyOnWriteArrayList<>();
    
    public void closeCurrentlyOpen() {
        for (ServerObject server : this.servers) {
            stopAndRemove(server);
            this.servers.remove(server); // This is safe in CopyOnWriteArrayList
        }
    }
    
    private void stopAndRemove(ServerObject server) {
        // Method implementation here
    }
    
    public static void main(String[] args) {
    }
}

class ServerObject {
    // Class implementation here
}