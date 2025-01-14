import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathUtils_2 {
    public int add(int a, int b) { return a + b; }

    @Test
    public void testAdd() {
        assertEquals(5, new MathUtils_2().add(2, 3));
    }

    public static void main(String[] args) {
    }
}