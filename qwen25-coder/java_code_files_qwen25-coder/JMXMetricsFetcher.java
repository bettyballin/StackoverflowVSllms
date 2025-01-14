import java.lang.String;
import java.lang.Integer;
import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.management.openmbean.CompositeDataSupport;

public class JMXMetricsFetcher {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java JMXMetricsFetcher <jmx-url>");
            return;
        }

        String urlString = args[0];
        try {
            JMXServiceURL url = new JMXServiceURL(urlString);
            JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

            ObjectName heapMemoryUsageObj = new ObjectName("java.lang:type=Memory");
            CompositeDataSupport heapMemoryUsage = (CompositeDataSupport) mbsc.getAttribute(heapMemoryUsageObj, "HeapMemoryUsage");

            long usedHeapMemory = (Long) heapMemoryUsage.get("used");

            ObjectName threadCountObj = new ObjectName("java.lang:type=Threading");
            Integer threadCount = (Integer) mbsc.getAttribute(threadCountObj, "ThreadCount");

            System.out.println("Used Heap Memory: " + usedHeapMemory);
            System.out.println("Thread Count: " + threadCount);

            jmxc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}