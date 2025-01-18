import javax.management.*;

public interface MyAppMBean {
    // Interface definition can be empty or contain method declarations
}

public class HelloMBean implements NotificationBroadcaster, MyAppMBean {
    private final MBeanServer server;

    public HelloMBean(MBeanServer server) {
        this.server = server;
    }

    public String getMessage() throws Exception {
        return "Hello World";  // This method will be accessible from the command line via JMX interface
    }

    public static void main(String[] args) {
    }

    @Override
    public void addNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback) {
        // Implementation goes here
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[0];
    }

    @Override
    public void removeNotificationListener(NotificationListener listener) throws ListenerNotFoundException {
        // Implementation goes here
    }

    @Override
    public void removeNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback) throws ListenerNotFoundException {
        // Implementation goes here
    }
}