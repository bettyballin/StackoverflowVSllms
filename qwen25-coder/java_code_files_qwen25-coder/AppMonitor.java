import java.lang.String;
import javax.management.*;
import java.lang.management.ManagementFactory; // Added this import

public class AppMonitor {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        CustomApp customApp = new CustomApp();
        ObjectName name = new ObjectName("com.example:type=CustomApp");
        mbs.registerMBean(customApp, name);
        System.out.println("Registering: " + name);

        // Wait forever since we are monitoring
        Thread.sleep(Long.MAX_VALUE);
    }
}

// Define the CustomAppMBean interface
public interface CustomAppMBean {
    // Define methods to be exposed via JMX
    public void doSomething();
}

// Implement the CustomAppMBean interface
public class CustomApp implements CustomAppMBean {
    public void doSomething() {
        System.out.println("CustomApp is doing something.");
    }
}