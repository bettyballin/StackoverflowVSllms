public class None_41_41 {
    // Compile-time error: syntax error
    // int x = "hello"; // compiler will report an error

    // Runtime error: division by zero
    public static void main(String[] args) {
        try {
            int y = 5 / 0; // will throw ArithmeticException at runtime
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }
}