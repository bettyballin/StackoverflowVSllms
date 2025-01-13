import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class SystemPropertyMonitor {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName on = new ObjectName("java.lang:type=Runtime");

        // Get the SystemProperties MBean
        Object systemProperties = mbs.getAttribute(on, "SystemProperties");

        // Monitor system property changes
        while (true) {
            System.out.println(systemProperties);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}