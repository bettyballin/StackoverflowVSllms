// Example of a simple function to test and its unit test
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }
}

// Unit Test for the MathUtils class
class MathUtilsTest {

    @Test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(5, mathUtils.add(2, 3), "2 + 3 should equal 5");
    }
}