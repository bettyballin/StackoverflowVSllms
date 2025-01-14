import java.lang.String;
public class SimpleOptimizer {
    public static int foldConstants(int a, int b) {
        return a + b; // This is a compile-time operation if a and b are constants
    }

    public static void main(String[] args) {
        int result = foldConstants(5, 3);
        System.out.println("Result of constant folding: " + result); // Output will be 8
    }
}