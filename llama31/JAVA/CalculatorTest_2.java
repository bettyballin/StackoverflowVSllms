import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Example of a simple unit test using JUnit
public class CalculatorTest_2_2 {
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.add(1, 1));
    }

    @Test
    public void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.subtract(1, 1));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_2");
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