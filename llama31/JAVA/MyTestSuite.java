import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ /* Add your test classes here */ })

public class MyTestSuite {
    public static org.junit.runner.RunWith.Suite suite() {
        org.junit.runner.RunWith.Suite suite = new org.junit.runner.RunWith.Suite();
        // Add your tests to the suite here
        return suite;
    }

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("MyTestSuite");
	}
}