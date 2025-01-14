import java.lang.String;
// Example of Java supporting self-recursive tail-call optimization:
public class Factorial {
    public static long factorial(int n) {
        return factorialHelper(n, 1);
    }

    private static long factorialHelper(int n, long acc) {
        if (n <= 1) return acc;
        else return factorialHelper(n - 1, n * acc); // Tail-recursive call
    }

	public static void main(String[] args) {
	}
}