import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_13_13 {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(2 + 2, calculator.add(2, 2));
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(2 - 2, calculator.subtract(2, 2));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_13");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}