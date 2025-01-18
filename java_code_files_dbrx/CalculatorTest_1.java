import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest_1 {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, new Calculator().add(2, 2));
    }

    public static void main(String[] args) {
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}