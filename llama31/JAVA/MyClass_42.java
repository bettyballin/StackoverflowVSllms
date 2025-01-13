import org.junit.Test;

public class MyClass_42_42 {
    private int calculateSomething() {
        // complex calculation
        return 1; // Replace with actual calculation
    }

    public int doSomething() {
        return calculateSomething();
    }

    public static class Calculator {
        public int calculateSomething() {
            // complex calculation
            return 1; // Replace with actual calculation
        }
    }

    public static class MyClass_42Test {
        @Test
        public void testDoSomething() {
            MyClass_42 obj = new MyClass_42();
            int result = obj.doSomething();
            // verify result
            System.out.println("Result: " + result);
        }

        @Test
        public void testCalculator() {
            Calculator calc = new Calculator();
            int result = calc.calculateSomething();
            // verify result
            System.out.println("Result: " + result);
        }
    }

    public static void main(String[] args) {
        MyClass_42Test test = new MyClass_42Test();
        test.testDoSomething();
        test.testCalculator();
    }
}