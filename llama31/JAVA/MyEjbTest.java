import java.lang.String;
import org.dbunit.DatabaseTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.junit.Test;

public class MyEjbTest extends DatabaseTestCase {
    @Override
    protected IDatabaseTester newDatabaseTester() throws Exception {
        return new PropertiesBasedJdbcDatabaseTester(System.getProperty("database.properties"));
    }

    @Test
    public void testMyEjbMethod() throws Exception {
        // Test your EJB method
        // ...
    }

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("MyEjbTest");
	}
}