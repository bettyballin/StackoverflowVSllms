import java.lang.String;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCalculator {
    @Test
    public void testAdd() {
        assertEquals(3, new Calculator().add(1, 2));
    }

    public static void main(String[] args) {
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}