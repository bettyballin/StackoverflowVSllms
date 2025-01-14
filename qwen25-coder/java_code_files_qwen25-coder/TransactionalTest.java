// File: TransactionalTest.java

// Example of using OpenEJB in a JUnit test
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.testing.EjbContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransactionalTest {
    private static EjbContainer ejbContainer;

    @BeforeClass
    public static void setUpEJBContainer() throws Exception {
        ejbContainer = EjbContainer.createEJBContainer();
    }

    @AfterClass
    public static void tearDownEJBContainer() {
        ejbContainer.close();
    }

    @Test
    public void testTransactionalBehavior() {
        // Write test logic here to verify transactional behavior
    }
}