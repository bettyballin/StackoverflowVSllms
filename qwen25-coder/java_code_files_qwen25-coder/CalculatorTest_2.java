import java.lang.String;
// Example Test Case using JUnit
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest_2 {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    public static void main(String[] args) {
        CalculatorTest_2 test = new CalculatorTest_2();
        test.testAddition();
        System.out.println("Test passed.");
    }
}

// Corresponding Implementation in Calculator.java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}