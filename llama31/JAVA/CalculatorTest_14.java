import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_14_14 {
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.add(1, 1));
    }
}

class Calculator {
    public int add(int a, int b) {
        // minimal implementation to make the test pass
        return a + b;
    }

    public static void main(String[] args) {
    }
}