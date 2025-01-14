import java.lang.String;
public class Calculator_6 {
    public int calculate(int a, int b) {
        return subtract(add(a, b), multiply(a, b));
    }

    // Refactor to package-private for testing
    int add(int a, int b) {
        return a + b;
    }

    // Refactor to package-private for testing
    int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

	public static void main(String[] args) {
	}
}