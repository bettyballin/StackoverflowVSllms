import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;

public class MyObjectTest_1 {
    @Test
    public void testDefaultConstructor() {
        MyObject obj = new MyObject();
        assertNotEquals(null, obj); // Ensures object is created and not optimized away
    }

    public static void main(String[] args) {
    }
}

class MyObject {
}