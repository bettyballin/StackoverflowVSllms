import java.lang.String;
// TDD Example: Writing test first
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_7 {
    @Test
    public void shouldAddTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
    }
}