import java.util.*;

public class Problem245 {
    public static void main(String[] args) {
        long limit = (long) Math.pow(10, 8); // Search up to 10^8 for demonstration
        long sum = 0;
        Set<Long> primesSet = sieveOfEratosthenes((int) Math.sqrt(limit) + 1);
        
        for (long k = 2; k <= limit; k += 2) { // k is always even
            // p and q are prime numbers such that n = pq, where p > q > k
            long minFactor = findMinFactor(k);
            if (minFactor == -1) continue;
            
            long maxSearch = (long)(k * Math.log(k));
            for (long factor = minFactor; factor < maxSearch; factor++) {
                // Calculate potential primes q, p from the relationship
                long q = k + factor;
                if (!primesSet.contains(q) || q <= k) continue;
                
                long product = k * k - k + 1;
                if (product % factor != 0) continue;
                long p = product / factor + k;
                if (!primesSet.contains(p) || p <= q) continue;

                // Construct n
                long n = p * q;
                if (n > limit) break;
                
                sum += n;
            }
        }
        
        System.out.println("Sum of all valid n up to " + limit + ": " + sum);
    }

    private static Set<Long> sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Long> primesSet = new HashSet<>();
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                primesSet.add((long)i);
            }
        }

        return primesSet;
    }

    private static long findMinFactor(long k) {
        for (long factor = 1; ; factor++) {
            long q = k + factor, product = k * k - k + 1;
            if (product % factor == 0) return factor;
        }
    }
}