import javax.management.Attribute;
import javax.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class LogConfigurator {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName log4jMBean = new ObjectName("log4j:logger=myLogger");
        mbs.setAttribute(log4jMBean, new Attribute("Level", "DEBUG"));
    }
}