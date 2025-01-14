import java.lang.String;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {}

class Assert {
    public static void assertEquals(String msg, int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(msg + " Expected: " + expected + " but was: " + actual);
        }
    }
}

public class CalculatorTest_15 {

    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        Assert.assertEquals("Expected addition of 2 + 3 to equal 5", 5, result);
    }

    public static void main(String[] args) throws Exception {
        CalculatorTest_15 test = new CalculatorTest_15();
        for (java.lang.reflect.Method m : test.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                m.invoke(test);
            }
        }
        System.out.println("All tests passed.");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
    }
}