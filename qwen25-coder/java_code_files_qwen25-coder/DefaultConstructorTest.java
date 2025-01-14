import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;

public class DefaultConstructorTest {
    @Test
    public void testDefaultConstructor() {
        boolean[] results = new boolean[10];
        for (int i = 0; i < results.length; i++) {
            MyObject obj = new MyObject();
            results[i] = (obj != null);
        }
        
        assertTrue(Arrays.stream(results).allMatch(Boolean::booleanValue)); // Check all are true
    }

    public static void main(String[] args) {
    }
}

class MyObject {
    // Default constructor is implicitly provided
}