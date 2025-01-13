// Define the Calculator class
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_8_8 {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 2);
        assertEquals(4, result);
    }

    public static void main(String[] args) {
        // Since this is a JUnit test, you would typically run it with a JUnit runner.
        // However, for simplicity, we can also run the test method directly.
        CalculatorTest_8 test = new CalculatorTest_8();
        test.testAddition();
        System.out.println("Test finished.");
    }
}