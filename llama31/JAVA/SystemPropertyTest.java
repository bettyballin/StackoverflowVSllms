import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SystemPropertyTest {
    @Test
    public void testSystemProperty() {
        // Set the property for testing purposes within the test
        System.setProperty("system.test.property", "someValue");
        assertTrue(System.getProperty("system.test.property") != null);
    }

    public static void main(String[] args) {
        // For demonstration, running the test method directly
        SystemPropertyTest test = new SystemPropertyTest();
        test.testSystemProperty();
        System.out.println("Test executed.");
    }
}