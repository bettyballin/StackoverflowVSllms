import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ServerManager {
    private List<ServerObject> servers = Collections.synchronizedList(new ArrayList<>()); // or use CopyOnWriteArrayList instead if suitable for your case as per above discussion

    public void closeCurrentlyOpen() {
        synchronized (servers) {
            Iterator<ServerObject> iterator = servers.iterator();
            while (iterator.hasNext()) {
                ServerObject serverToRemove = iterator.next();
                stopAndRemove(serverToRemove); // assuming that method doesn't modify the list as well
                iterator.remove();
            }
        }
    }

    public void addServerToList(ServerObject server) { // synchronized to avoid conflicts with closeCurrentlyOpen() adding new elements while it is closing currently opened ones.
        servers.add(server);
    }

    // This synchronization should not be necessary anymore if the rest of your code works correctly:
    public void stopAndRemove(ServerObject server) {
        // Performing necessary operations to 'stop' the ServerObject instance, then removing it from the list once stopped/closed...
    }

    public static void main(String[] args) {
    }
}

class ServerObject {
    // Placeholder for the ServerObject class
}