import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator_7Test {
    // Step 1: Write a test that fails
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest");
    }
}

// Step 2: Write the minimal amount of code to make the test pass
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}