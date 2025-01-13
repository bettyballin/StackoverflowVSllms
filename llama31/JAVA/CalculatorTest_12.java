import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_12_12 {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_12");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}