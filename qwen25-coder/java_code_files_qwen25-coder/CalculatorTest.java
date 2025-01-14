import org.junit.Test;
import static org.junit.Assert.*;

// Example of a simple unit test in JUnit for Java
public class CalculatorTest {
    @Test
    public void testAddition() {
        assertEquals(5, new Calculator().add(2, 3));
    }

    public static void main(String[] args) {
        // You can run your tests here if needed
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}