import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

public class DcomManager {
    // A singleton instance of the manager
    private static final DcomManager INSTANCE = new DcomManager();

    // Use ConcurrentHashMap to manage multiple instances if needed
    private final ConcurrentHashMap<String, ActiveObject> dcomInstances;

    private DcomManager() {
        dcomInstances = new ConcurrentHashMap<>();
    }

    public static DcomManager getInstance() {
        return INSTANCE;
    }

    // Method to get or create a new DCOM instance
    public MyDcomInterface getOrCreateDcomInstance(String clientId) throws Exception {
        // Try to get the existing one
        ActiveObject dcom = dcomInstances.get(clientId);

        if (dcom == null) {
            synchronized (this) { // Synchronize to prevent multiple creations
                dcom = dcomInstances.computeIfAbsent(clientId, id -> {
                    try {
                        return new ActiveObject("CLSID_OF_YOUR_DCOM_OBJECT");
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to create DCOM object", e);
                    }
                });
            }
        }

        // Return the DCOM object cast to your specific interface
        return (MyDcomInterface) dcom.queryInterface(MyDcomInterface.class);
    }

    // Method to remove a DCOM instance when done
    public void releaseDcomInstance(String clientId) {
        ActiveObject dcom = dcomInstances.remove(clientId);
        if (dcom != null) {
            try {
                dcom.release();
            } catch (Exception e) {
                e.printStackTrace(); // Handle appropriately in production
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String clientId = UUID.randomUUID().toString();

        DcomManager manager = DcomManager.getInstance();
        MyDcomInterface dcomObject = manager.getOrCreateDcomInstance(clientId);

        // Use the DCOM object

        // Release when done
        manager.releaseDcomInstance(clientId);
    }
}

// Assuming you have a specific interface for your DCOM object
interface MyDcomInterface {
    // Define methods as appropriate
}

// Define ActiveObject class
class ActiveObject {
    public ActiveObject(String clsid) throws Exception {
        // Constructor implementation
    }

    public <T> T queryInterface(Class<T> cls) {
        // Simulate returning an instance of T
        // For testing purposes, return null or a mock implementation
        return null;
    }

    public void release() {
        // Release resources
    }
}