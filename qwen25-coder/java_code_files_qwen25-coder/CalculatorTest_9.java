import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest_9 {
    @Test
    public void testAddition() {
        // Arrange
        Calculator calculator = new Calculator();
        
        // Act
        int result = calculator.add(2, 3);
        
        // Assert
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    public static void main(String[] args) {
        // You can run tests here if desired
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}