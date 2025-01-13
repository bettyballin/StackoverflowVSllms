import java.lang.String;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class MyObject_5_5 implements MyObjectMBean {
    public static void main(String[] args) throws Exception {
        // Create an MBeanServer
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        // Create an MBean
        MyObject myObject = new MyObject();

        // Register the MBean with the MBeanServer
        ObjectName objectName = new ObjectName("my.object:type=MyObject");
        server.registerMBean(myObject, objectName);

        // Start the JMX remote connector
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnector connector = JMXConnectorFactory.connect(url);

        // Now you can access your MBean remotely using a JMX client
    }
}