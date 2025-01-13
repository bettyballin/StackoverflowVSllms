import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Define MyClass with myMethod
class MyClass {
    public int myMethod(int a, int b) {
        return a + b;
    }
}

public class MyClassTest_1_1 {
    @Test
    public void testMyMethod() {
        MyClass myClass = new MyClass();
        int result = myClass.myMethod(2, 3);
        assertEquals(5, result);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("MyClassTest_1");
    }
}