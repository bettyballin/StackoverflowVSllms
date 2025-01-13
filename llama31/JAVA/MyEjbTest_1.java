import java.lang.String;
import org.junit.Before;
import org.junit.Test;
import org.apache.openejb.client.LocalInitialContextFactory;
import javax.naming.InitialContext;

public class MyEjbTest_1_1 {
    @Before
    public void setUp() throws Exception {
        // Create an embedded container
        System.setProperty("java.naming.factory.initial", LocalInitialContextFactory.class.getName());
        // Deploy your EJB module
        // ...
    }

    @Test
    public void testTransactionAttribute() throws Exception {
        // Lookup your EJB
        MyEjb ejb = (MyEjb) new InitialContext().lookup("MyEjbLocal");
        // Test the transaction attribute
        // ...
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("MyEjbTest_1");
    }
}