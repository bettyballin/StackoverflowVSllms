import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.*;

// TAD Example: Writing test after code
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest_6 {
    @Test
    public void shouldAddTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    public static void main(String[] args) {
    }
}