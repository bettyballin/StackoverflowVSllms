import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyObjectTest {
    @Test
    public void testDefaultConstructor() {
        List<MyObject> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new MyObject());
        }

        assertEquals(10, objects.size()); // Ensure objects are created
    }

    public static void main(String[] args) {
    }
}

class MyObject {
    // Default constructor
}