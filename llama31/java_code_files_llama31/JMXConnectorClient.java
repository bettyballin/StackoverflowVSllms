/*
 * Decompiled with CFR 0.152.
 */
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JMXConnectorClient {
    public static void main(String[] stringArray) throws Exception {
        JMXServiceURL jMXServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnector jMXConnector = JMXConnectorFactory.connect(jMXServiceURL);
        MBeanServerConnection mBeanServerConnection = jMXConnector.getMBeanServerConnection();
    }
}
