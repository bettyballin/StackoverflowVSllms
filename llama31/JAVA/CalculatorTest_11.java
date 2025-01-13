import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_11_11 {
    // example of JUnit test for a critical Java method
    @Test
    public void testAdd() {
        int result = add(2, 3);
        assertEquals(5, result);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
    }
}