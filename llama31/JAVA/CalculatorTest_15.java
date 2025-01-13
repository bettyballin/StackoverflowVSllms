// Calculator.java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return a / b;
    }
}

// CalculatorTest_15.java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest_15_15 {

    @InjectMocks
    private Calculator calculator = new Calculator(); // Direct instantiation for simplicity

    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 10;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testDivideByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act and Assert
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        assertEquals("/ by zero", exception.getMessage());
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_15");
    }
}