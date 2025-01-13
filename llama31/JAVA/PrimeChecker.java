import java.lang.String;

public class PrimeChecker {
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0) return false;
        return n > 1;
    }

    public static void main(String[] args) {
    }
}