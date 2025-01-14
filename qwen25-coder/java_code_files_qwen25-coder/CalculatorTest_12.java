import java.lang.String;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest_12 {
    @Test
    public void testAdd() {
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