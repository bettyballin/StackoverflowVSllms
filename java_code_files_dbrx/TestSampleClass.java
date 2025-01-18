import java.lang.String;

public class TestSampleClass {
    @Test
    public void testMultiply() {
        SampleClass obj = new SampleClass();
        int result = obj.multiply(2, 6);
        Assert.assertEquals(12, result);
    }

    public static void main(String[] args) {
        new TestSampleClass().testMultiply();
    }
}

// Minimal JUnit Test annotation
@interface Test {
}

// Minimal JUnit Assert class
class Assert {
    public static void assertEquals(int expected, int actual) {
        if (expected != actual)
            throw new AssertionError("Expected " + expected + " but got " + actual);
    }
}

// SampleClass with the multiply method
class SampleClass {
    public int multiply(int a, int b) {
        return a * b;
    }
}