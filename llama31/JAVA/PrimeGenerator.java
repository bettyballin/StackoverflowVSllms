import java.lang.Integer;
import java.util.ArrayList; // Changed import statement
import java.lang.String;

public class PrimeGenerator {
    public static ArrayList<Integer> generatePrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n * 10]; // rough estimate of upper bound
        java.util.Arrays.fill(isPrime, true); // Added java.util to Arrays
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; primes.size() < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        // Example usage:
        ArrayList<Integer> primes = generatePrimes(10);
        System.out.println(primes);
    }
}