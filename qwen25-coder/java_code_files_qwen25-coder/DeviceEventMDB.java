import java.util.HashMap;
import java.util.Map;

// Simulate javax.annotation.Resource
@interface Resource {
    String name() default "";
}

// Simulate javax.ejb.EJB
@interface EJB {
    String name() default "";
}

// Simulate javax.ejb.MessageDriven
@interface MessageDriven {
    String mappedName() default "";
}

// Simulate javax.ejb.SessionContext
interface SessionContext {
    Object getBusinessObject(Class<?> clazz) throws Exception;
}

// Simulate javax.jms.MessageListener
interface MessageListener {
    void onMessage(Message message);
}

// Simulate javax.jms.Message
interface Message {
}

// Simulate javax.jms.TextMessage
interface TextMessage extends Message {
    String getStringProperty(String name) throws JMSException;
    String getText() throws JMSException;
}

// Simulate javax.jms.JMSException
class JMSException extends Exception {
    public JMSException(String message) {
        super(message);
    }
}

// DeviceStatefulBeanLocal interface
interface DeviceStatefulBeanLocal {
    void processEvent(String eventData);
}

// DeviceStatefulBean class
class DeviceStatefulBean implements DeviceStatefulBeanLocal {
    @Override
    public void processEvent(String eventData) {
        // Do something
    }
}

// Implement SessionContext
class MySessionContext implements SessionContext {
    @Override
    public Object getBusinessObject(Class<?> clazz) throws Exception {
        return clazz.getDeclaredConstructor().newInstance();
    }
}

// Implement TextMessage
class MyTextMessage implements TextMessage {
    @Override
    public String getStringProperty(String name) throws JMSException {
        return "dummyDeviceId";
    }

    @Override
    public String getText() throws JMSException {
        return "dummyEventData";
    }
}

@MessageDriven(mappedName = "jms/DeviceEventQueue")
public class DeviceEventMDB implements MessageListener {

    @Resource
    private SessionContext context;

    @EJB
    private DeviceStatefulBean deviceStatefulBeanLocal;

    private static final Map<String, DeviceStatefulBeanLocal> sfsbCache = new HashMap<>();

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String deviceId = textMessage.getStringProperty("deviceId");
            String eventData = textMessage.getText();

            DeviceStatefulBeanLocal sfsb = sfsbCache.computeIfAbsent(deviceId, id -> {
                try {
                    return (DeviceStatefulBeanLocal) context.getBusinessObject(DeviceStatefulBean.class);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to create SFSB for device: " + deviceId, e);
                }
            });

            sfsb.processEvent(eventData);

        } catch (JMSException | RuntimeException e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

    // Optionally, implement a mechanism to remove stale entries or timeout SFSBs

    public static void main(String[] args) {
        DeviceEventMDB mdb = new DeviceEventMDB();
        mdb.context = new MySessionContext();
        mdb.onMessage(new MyTextMessage());
    }
}