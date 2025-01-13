import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.ConversationScoped;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.inject.Inject;

@Stateful
@ConversationScoped
public class DeviceSession {
    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public boolean isConversationStarted() {
        // Assuming a basic implementation, replace with actual logic
        return device != null;
    }

    public void beginConversation() {
        // Assuming a basic implementation, replace with actual logic
        device = new Device();
    }
}

@MessageDriven
public class EventMessageBean implements MessageListener {
    @Inject
    private DeviceSession deviceSession;

    @Override
    public void onMessage(Message message) {
        // Get the device ID from the message
        String deviceId = message.getStringProperty("deviceId");

        // Start a new conversation for the device
        if (!deviceSession.isConversationStarted()) {
            deviceSession.beginConversation();
        }

        // Load the device info from the database
        Device device = loadDeviceInfoFromDB(deviceId);
        deviceSession.setDevice(device);

        // Process the event message
        processEventMessage(message);
    }

    private Device loadDeviceInfoFromDB(String deviceId) {
        // Assuming a basic implementation, replace with actual database logic
        return new Device();
    }

    private void processEventMessage(Message message) {
        // Assuming a basic implementation, replace with actual processing logic
    }

    public static void main(String[] args) {
    }
}

class Device {
    // Assuming a basic implementation, replace with actual device properties
}