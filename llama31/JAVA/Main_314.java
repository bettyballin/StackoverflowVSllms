import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Main_314 {
    public static void main(String[] args) throws Exception {
        // Replace <container_host> and <container_port> with actual values
        String containerHost = "localhost"; // replace with actual host
        int containerPort = 1099; // replace with actual port
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + containerHost + ":" + containerPort + "/jmxrmi");
        JMXConnector connector = JMXConnectorFactory.connect(url);
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("java.lang:type=OperatingSystem");
        OperatingSystemMXBean osMXBean = ManagementFactory.getOperatingSystemMXBean();

        // Collect metrics from osMXBean, such as CPU usage, memory usage, etc.
        System.out.println("System CPU load: " + osMXBean.getSystemCpuLoad());
        System.out.println("System CPU time: " + osMXBean.getProcessCpuTime());
        System.out.println("Total physical memory: " + osMXBean.getTotalPhysicalMemorySize());
        System.out.println("Free physical memory: " + osMXBean.getFreePhysicalMemorySize());
        connector.close();
    }
}