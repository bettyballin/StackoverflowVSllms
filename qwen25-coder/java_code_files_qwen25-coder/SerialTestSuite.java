import java.lang.String;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {   TestCase1.class,
        TestCase2.class,
        // Add all individual tests here or use separate suite classes for different categories of tests
    }
)
public class SerialTestSuite {

	public static void main(String[] args) {
	}
}

class TestCase1 {
    // Dummy test case class for compilation
}

class TestCase2 {
    // Dummy test case class for compilation
}