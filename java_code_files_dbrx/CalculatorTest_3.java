import java.lang.String;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest_3 {
    @Test
    public void addNumbers() {
        assertEquals(5, new Calculator().add(2, 3));
    }

    public static void main(String[] args) {
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}