import java.lang.String;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class RMIServerTestSuite extends TestSuite {
    private static Registry registry;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(RMIServerTestSuite.class);
    }

    public RMIServerTestSuite() {
        super();
        try {
            registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            throw new RuntimeException(e);
        }
    }

    public void tearDown() {
        try {
            registry.unbind("MyServer");
            registry = null;
        } catch (Exception e) {
            System.out.println("Exception shutting down RMI registry:");
        }
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(MyClientTest.class);
        // Add more test classes as needed
        return suite;
    }
}

public class MyClientTest extends TestCase {
    public void testMyClient() {
        // client setup
        MyClient m = null;
        try {
            m = (MyClient) Naming.lookup("//MyHost/MyServer");
        } catch (Exception e) {
            System.out.println("Exception looking up MyServer:");
        }
        // tests here
    }
}