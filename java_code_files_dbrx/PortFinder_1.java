import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Set;

interface HttpServletRequest {
    // Empty interface for compilation purposes
}

public class PortFinder {

    public void findPort(HttpServletRequest request) {
        String port = ""; // port will be set if found, leave it empty otherwise
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNames = mbs.queryNames(new ObjectName("Catalina:type=Connector,*"), null);
            for (ObjectName objectName : objectNames) {
                String protocol = (String) mbs.getAttribute(objectName, "protocol");
                if ("HTTP/1.1".equalsIgnoreCase(protocol)) { // or check whatever is needed to ensure 'secure'
                    port = (String) mbs.getAttribute(objectName, "port");
                }
            }
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        } finally {
            // do something with the value of `port` here or return/save it for later
            System.out.println("Port: " + port);
        }
    }
}