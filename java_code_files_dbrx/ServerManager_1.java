import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerManager {

    // Variable declaration
    List<ServerObject> servers = new CopyOnWriteArrayList<ServerObject>();

    // Methods
    public void closeCurrentlyOpen() {
        for(ServerObject server : this.servers) {
            stopAndRemove(server);
        }
    }

    public synchronized void addServerToList(ServerObject server) {
        // Your code here to add a new ServerObject in the list...
        this.servers.add(server);
    }

    public void stopAndRemove(ServerObject server) {
        // code to stop and remove the server
        // For compilation purposes, we can leave it empty
    }

}

class ServerObject {
    // minimal definition
}