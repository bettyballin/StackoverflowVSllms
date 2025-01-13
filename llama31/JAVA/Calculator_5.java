import java.lang.String;
// Example of a software fault in Java
public class Calculator_5 {
    public int add(int a, int b) {
        // Fault: incorrect implementation of addition
        return a - b; // instead of a + b
    }

	public static void main(String[] args) {
	}
}