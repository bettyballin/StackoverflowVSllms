import java.lang.reflect.Array;
import static org.junit.Assert.assertEquals;

public class ArrayAssertHelper {
    public void assertArrays(String[] actual, String[] expected) {
        assertEquals("Array lengths differ", Array.getLength(expected), Array.getLength(actual));
        for (int i = 0; i < actual.length; i++) {
            assertEquals("Values at index " + i + " are different", expected[i], actual[i]);
        }
    }
    public static void main(String[] args) {
    }
}