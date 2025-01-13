import javax.management.MBeanServer;
import javax.management.ManagementFactory;
import javax.management.ObjectName;
import javax.management.StandardMBean;

// Define the MBean interface
public interface MyMBeanMBean {
    // Add your MBean interface methods here
}

// MyMBean class implementing MyMBeanMBean
class MyMBean implements MyMBeanMBean {
    // Implement your MBean logic here
}

public class Main {
    public static void main(String[] args) throws Exception {
        // Register the MBean with the MBean server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName on = new ObjectName("my.domain:type=MyMBean");
        StandardMBean mbean = new StandardMBean(new MyMBean(), MyMBeanMBean.class);
        mbs.registerMBean(mbean, on);
    }
}