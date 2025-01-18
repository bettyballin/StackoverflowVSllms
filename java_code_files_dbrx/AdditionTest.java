import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdditionTest {
    @Test
    public void testAddition() {
        int result = MyClass.add(2, 3);
        assertEquals(5, result); // Assertion will pass if expected and actual results match
    }
    public static void main(String[] args) {
    }
}

class MyClass {
    public static int add(int a, int b) {
        return a + b;
    }
}