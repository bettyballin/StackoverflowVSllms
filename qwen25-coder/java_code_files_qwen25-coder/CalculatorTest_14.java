import java.lang.String;
// Example in Java using JUnit
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest_14 {

    @Test
    public void shouldAddTwoPositiveNumbers() {
        // Setup
        Calculator calculator = new Calculator();

        // Execute
        int result = calculator.add(1, 2);

        // Assert
        assertEquals("Sum of two numbers", 3, result);
    }

    public static void main(String[] args) {
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}