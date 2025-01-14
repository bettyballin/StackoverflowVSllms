import java.util.ArrayList;

public class PrimeGenerator {
    public static ArrayList<Integer> generatePrimes(int n) {
        if (n < 1) throw new IllegalArgumentException("n must be greater than 0");
        
        ArrayList<Integer> primes = new ArrayList<>();
        int num = 2; // starting number to check for prime

        while (primes.size() < n) {
            boolean isPrime = true;
            
            for (int p : primes) {
                if (num % p == 0) {
                    isPrime = false;
                    break;
                }
                if (p * p > num) break; // no need to check beyond the square root of num
            }

            if (isPrime) primes.add(num);
            
            num++;
        }
        
        return primes;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> primeNumbers = generatePrimes(n);
        System.out.println(primeNumbers); // Output: [2, 3, 5, 7, 11]
    }
}