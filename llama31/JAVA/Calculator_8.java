// Calculator.java
public class Calculator_8 {
    public int add(int a, int b) {
        return a + b; // Implementation to add two numbers
    }
}

// CalculatorTest.java
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator_8Test {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
}