import java.lang.String;
public class PrimeGenerator_1 {
    public static void main(String[] args) {
        int limit = 10000;
        boolean[] isPrime = new boolean[limit * 15]; // rough estimate for the upper bound
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < isPrime.length && count < limit; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }
    }
}