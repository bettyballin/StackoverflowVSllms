import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

// Define the annotations since we don't have the EJB package
@interface Singleton {
    String name();
}

@interface Stateful {
    String name();
}

@interface Lock {
    LockType value();
}

enum LockType {
    READ,
    WRITE
}

// Singleton bean serving as coordinator and holding the map of active devices (DeviceInfo) mapped by their deviceId
@Singleton(name = "DeviceManager")
class DeviceCoordinatorBean {
    private Map<Long, DeviceStatefulBean> activeDevices = new HashMap<Long, DeviceStatefulBean>(); // Store DeviceSessionBeans referenced by their respective id/key

    @Lock(LockType.WRITE) // use WRITE lock to prevent concurrency issues while updating the map
    public void addDevice(long deviceId, DeviceInfo deviceInfo) { // Assuming you're using some sort of bean representing your devices with unique identifier (deviceId)
        // If a session does not exist for this device, create it.
        if (!activeDevices.containsKey(deviceId)) {
            activeDevices.put(deviceId, new DeviceStatefulBean());
        }
    }
}

class DeviceInfo { /*Device data*/ } // Some representation of your devices' info/details

// Stateful bean managing per-device state (possibly referenced via handles in the coordinator's activeDevices map)
@Stateful(name = "DeviceSessionBean")
class DeviceStatefulBean implements Serializable { /* your methods to manage device states */ }

public class MainClass {
    public static void main(String[] args) {
        // You can add code here to test the classes.
    }
}