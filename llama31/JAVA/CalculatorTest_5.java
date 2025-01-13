import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Write a test for a simple calculator
public class CalculatorTest_5_5 {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(1, 2));
    }
}

// Then, implement the Calculator class
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
    }
}