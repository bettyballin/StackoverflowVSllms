import javax.management.*;
import javax.management.remote.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.MalformedURLException;

public class MyApplication_1 {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        // Obtain Platform MBean Server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Create and register an instance of MyMXBeanImpl with the MBean server.
        ObjectName mbeanName = new ObjectName("com.jmx.example:type=Hello");
        MyMXBeanImpl hello = new MyMXBeanImpl("Hello World");
        mbs.registerMBean(hello, mbeanName);
        System.out.println("Waiting forever...");

        // Enable remote access
        try {
            JMXServiceURL url = new JMXServiceURL(
                    "service:jmx:rmi:///jndi/rmi://" + InetAddress.getLocalHost().getHostAddress() + ":9999/jmxrmi");
            JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
            cs.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Let it run forever
        Thread.sleep(Long.MAX_VALUE);
    }
}

interface MyMXBean {
    String getName();

    void setName(String name);

    void printName();
}

class MyMXBeanImpl extends NotificationBroadcasterSupport implements MyMXBean {
    private String name;

    public MyMXBeanImpl(String name) {
        this.name = name;
    }

    @Override
    public synchronized String getName() {
        return name;
    }

    @Override
    public synchronized void setName(String name) {
        this.name = name;
        // Send a notification when the name is changed (for example purposes)
        sendCustomNotification(name);
    }

    private synchronized void sendCustomNotification(String message) {
        Notification n = new Notification("example.notification.type", this, 0, System.currentTimeMillis(), message);
        sendNotification(n);
    }

    @Override
    public void printName() {
        System.out.println("Print name: " + getName());
    }
}