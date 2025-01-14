import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator_5 {

    public int add(int a, int b) { return a + b; }

    @Test
    public void testAdd() throws Exception {
        Calculator_5 calculator = new Calculator_5();
        assertEquals(5, calculator.add(2, 3));
    }

    public static void main(String[] args) {
    }
}