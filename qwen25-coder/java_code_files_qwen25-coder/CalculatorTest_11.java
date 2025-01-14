import java.lang.String;
// Example of a simple Unit Test using JUnit in Java
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest_11 {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_11");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}