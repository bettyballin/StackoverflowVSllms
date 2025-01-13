import org.junit.Test;

public class MyObjectTest {
    private volatile int sideEffect;

    @Test
    public void testDefaultConstructor() {
        new MyObject();
        sideEffect = 1; // Observable side effect
    }

    public static void main(String[] args) {
    }
}

class MyObject {
    // add a default constructor
    public MyObject() {}
}