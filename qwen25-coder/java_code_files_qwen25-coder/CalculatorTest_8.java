import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest_8 {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.add(5, 5));
    }
    
    private class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
    }
}