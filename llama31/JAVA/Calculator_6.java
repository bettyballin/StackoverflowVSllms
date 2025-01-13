import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator_6_6 {
    public int add(int a, int b) {
        return a + b;
    }
}

public class Calculator_6_6Test {
    @Test
    public void testAdd() {
        Calculator_6 calculator = new Calculator_6();
        assertEquals(3, calculator.add(1, 2));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("Calculator_6Test");
    }
}