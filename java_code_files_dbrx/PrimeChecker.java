import java.lang.String;
public class PrimeChecker {
    public static boolean isPrime(int x) {
        if (x <= 1 || x % 2 == 0 && x > 2) {
            return false; // Even numbers are not prime except for 2.
        }
        int divisorLimit = (int) Math.sqrt(x);
        for (int i = 3; i <= divisorLimit; i += 2) { // Odd dividers only.
            if (x % i == 0) return false;
        }
        return true;
    }

	public static void main(String[] args) {
	}
}