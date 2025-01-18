import java.lang.String;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addTest() {
        int result = new Calculator().add(2, 3);
        assertEquals(5, result);
    }

    public static void main(String[] args) {
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}