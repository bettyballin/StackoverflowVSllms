import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import javax.inject.Singleton;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageDriven;

@Singleton
public class DeviceCache {
    private Map<String, Device> deviceCache = new ConcurrentHashMap<>();

    public Device getDevice(String deviceId) {
        // load device info from DB if not cached
        // ...
        return null; // add a return statement
    }
}

@MessageDriven
public class EventMessageBean implements MessageListener {
    @Inject
    private DeviceCache deviceCache;

    public void onMessage(Message message) {
        String deviceId = null; // message.getStringProperty is not a standard method
        // you might need to cast message to a specific type or use a different method
        // to get the device id
        Device device = deviceCache.getDevice(deviceId);
        // process the event message
    }

    public static void main(String[] args) {
    }
}

// Define the Device class
class Device {
    // add fields and methods as needed
}