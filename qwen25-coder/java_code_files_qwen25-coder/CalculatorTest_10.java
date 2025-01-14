import java.lang.String;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest_10 {
    public static void main(String[] args) {
    }

    class CalculatorTest {
        @Test
        void testAddition() {
            Calculator calculator = new Calculator();
            assertEquals(5, calculator.add(2, 3));
        }
    }
}