import java.util.ArrayList;

public class PrimeGenerator {
    java.util.List<Integer> generatePrimes(int n) {
        int size = (int)(n * java.lang.Math.log(n));
        java.util.List<Boolean> sieve = new ArrayList<Boolean>(java.util.Collections.<Boolean>nCopies(size, Boolean.TRUE));
        java.util.List<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i < sieve.size(); ++i) {
            if (sieve.get(i)) {
                primes.add(i);
                for (int j = i * 2; j < sieve.size(); j += i) // Cross out multiples of current prime number
                    sieve.set(j, Boolean.FALSE);
            }
        }

        return primes;
    }
    public static void main(String[] args) {
    }
}