import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_4_4 {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.subtract(1, 1));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_4");
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