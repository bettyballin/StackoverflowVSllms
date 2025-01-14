import java.lang.String;
public class SafeDivisionHelper {
    // Example of writing a small piece of code then testing it:
    public int divide(int a, int b) {
        if (b == 0) { // Incremental check for division by zero
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }

    // Testing function
    public static void testDivideFunction() {
        try {
            SafeDivisionHelper helper = new SafeDivisionHelper();
            System.out.println(helper.divide(10, 2)); // Expected output: 5
            System.out.println(helper.divide(10, 0)); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        testDivideFunction();
    }
}