import java.lang.String;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class HereisasuggestedclassnamefortheJavacodeDeviceInfoMessageListenerThisnamereflectsthefactthattheclassislisteningtomessagesrelatedtodeviceinformationLetmeknowifyoudlikemetosuggestanychanges implements MessageListener {
    @Resource(name = "jms/your_connection", lookup = "jms/YourJMSFactory")
    private ConnectionFactory connectionFactory;
    // ... other annotations and code for MessageDrivenBean omitted here...

    private DeviceCoordinatorBean deviceCoordinatorBean; // Assuming this is needed

    @Override
    public void onMessage(Message message) { // Your typical onMessage method
        try {
            ObjectMessage objMsg = (ObjectMessage) message; // In case you're using messages with objects instead of text
            // Retrieve your device related object from the incoming message. Let me assume it is DeviceInfo type for simplicity.
            DeviceInfo receivedDeviceInfo = (DeviceInfo) objMsg.getObject();
            // This will call DeviceCoordinatorBean's addDevice() and create or retrieve an existing handle to a Stateful bean representing this particular device.
            // If no stateful bean was created yet for the current device info, its id wasn't found in DeviceManager#activeDevices map -> so you instantiate it.
            deviceCoordinatorBean.addDevice(receivedDeviceInfo.getDeviceId(), receivedDeviceInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}

// Stubs for missing classes to make the code compilable

class DeviceInfo implements Serializable {
    private String deviceId;

    public DeviceInfo(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }
}

class DeviceCoordinatorBean {
    public void addDevice(String deviceId, DeviceInfo deviceInfo) {
        // Implementation omitted
    }
}