import java.lang.String;
import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        MyMBeanImpl mbean = new MyMBeanImpl();
        ObjectName name = new ObjectName("com.example.myapp:type=MyMBean");
        mbs.registerMBean(mbean, name);
    }

    public void contextDestroyed(ServletContextEvent event) {
        // empty implementation
    }

    public static void main(String[] args) {
    }
}

// You need to implement MyMBeanImpl class
class MyMBeanImpl {
    // implement your MBean interface
}