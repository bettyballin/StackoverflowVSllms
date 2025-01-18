import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest_2 {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        this.calculator = new Calculator();
    }

    // The below test will fail initially as add function is not implemented yet
    @Test
    public void shouldAddTwoNumbers() throws Exception {
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }

    public static void main(String[] args) {
    }
}

class Calculator {
    public int add(int a, int b) {
        // Method not implemented yet
        return 0;
    }
}