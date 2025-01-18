import java.lang.String;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTests {
    @Test
    public void add_twoNumbers_returnsCorrectSum() {
        // arrange
        Calculator calculator = new Calculator();
        int num1 = 5, num2 = 3;

        // act
        int result = calculator.add(num1, num2);

        // assert
        assertEquals("The sum is incorrect", 8, result);
    }

    public static void main(String[] args) {
    }
}

// Calculator class definition
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}