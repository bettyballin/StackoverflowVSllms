import java.lang.annotation.*;

// Unit test example using JUnit for a Calculator addition method

import static Assert.assertEquals;

public class CalculatorTest_3 {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    public static void main(String[] args) {
        CalculatorTest_3 test = new CalculatorTest_3();
        test.testAddition();
        System.out.println("Test passed.");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}

class Assert {
    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected:<" + expected + "> but was:<" + actual + ">");
        }
    }
}