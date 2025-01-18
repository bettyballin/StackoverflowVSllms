import java.lang.String;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public abstract class BaseTest {
    // Setup environment, start EJB3 bean
    @BeforeClass
    public static void beforeAllTests() {}

    // Teardown environment after tests
    @AfterClass
    public static void afterAllTests() {}

    public static void main(String[] args) {
    }
}