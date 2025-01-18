import java.lang.management.ManagementFactory;
import javax.management.*;
import javax.management.remote.*;

public class MyApp {
    private final HelloMBean mbean;

    public static void main(String[] args) throws Exception {
        String host = "localhost";           // specify the address of either local or remote machines running your code
        int rmiPort = 9012;                  // set an open port number, e.g., 9012 for RMI Registry
        final ObjectName mxbeanName = new ObjectName("org.myapp:name=MyAppMXBean");

        MyApp app = new MyApp(host);         // create a new Application with its MBeans

        /*
         * Now that the application has registered an mbean, register that mbean's object name
         */
        ManagementFactory.getPlatformMBeanServer().registerMBean(app.mbean, mxbeanName);
        JMXServiceURL serviceUrl = new JMXServiceURL(
            "service:jmx:rmi:///jndi/rmi://" + host + ":" + rmiPort + "/server"
        );
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(
            serviceUrl, null, ManagementFactory.getPlatformMBeanServer()
        );
        cs.start();                          // start the server up and wait for connections (from our management client)
    }

    public MyApp(String host) {
        this.mbean = new Hello();
    }
}

interface HelloMBean {
    // Define MBean methods here
    void sayHello();
    int add(int x, int y);
}

class Hello implements HelloMBean {
    public void sayHello() {
        System.out.println("Hello, world!");
    }

    public int add(int x, int y) {
        return x + y;
    }
}