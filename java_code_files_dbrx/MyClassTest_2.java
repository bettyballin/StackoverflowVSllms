import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyClassTest_2 {
    @Test
    public void testMyMethod() {
        // Arrange (set up)
        MyClass myObject = new MyClass();

        // Act (execute the code being tested)
        int result = myObject.myMethod(5, 3);

        // Assert (check expected outcome against actual results)
        assertEquals(2, result); // Expected output is 2 since 5 % 3 == 2
    }

    public static void main(String[] args) {
        // You can optionally run your tests here
    }
}

class MyClass {
    public int myMethod(int a, int b) {
        return a % b;
    }
}