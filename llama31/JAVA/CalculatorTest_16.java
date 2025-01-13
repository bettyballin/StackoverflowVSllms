import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.String;

public class CalculatorTest_16_16 {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_16");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}