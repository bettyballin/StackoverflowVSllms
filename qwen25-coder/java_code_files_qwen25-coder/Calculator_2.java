import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Example class (existing codebase)
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

// Unit Test using JUnit
class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));
    }
}

// Integration Test using JUnit
class MathOperationsTest {

    @Test
    public void testAddAndMultiplyIntegration() {
        Calculator calculator = new Calculator();
        int sum = calculator.add(5, 5);
        int product = calculator.multiply(sum, 2); // (5 + 5) * 2
        assertEquals(20, product);
    }
}