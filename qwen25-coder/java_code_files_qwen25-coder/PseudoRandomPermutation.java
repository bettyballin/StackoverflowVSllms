import java.security.SecureRandom;

public class PseudoRandomPermutation {

    private final int n;
    private final int m;
    private final int a;
    private final int c;
    private final int mod;

    public PseudoRandomPermutation(int start, int end) {
        this.n = start;
        this.m = end - start + 1;
        this.mod = m;
        
        SecureRandom random = new SecureRandom();
        
        // Choose a and c such that the LCG can produce a full period
        int tempA, tempC;
        do {
            tempA = 2 * random.nextInt(mod) + 1; // a must be odd for full period
            tempC = random.nextInt(mod);
        } while (gcd(tempA - 1, mod) != 1); // gcd(a-1, m) should be 1 for full cycle
        this.a = tempA;
        this.c = tempC;
    }

    public int f(int i) {
        if (i < 1 || i > m) throw new IllegalArgumentException("Index out of bounds");
        return n + lcg(i - 1);
    }

    private int lcg(int x) {
        long result = ((long)a * x + c) % mod;
        return (int)((result + mod) % mod); // Ensure result is non-negative
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        PseudoRandomPermutation prp = new PseudoRandomPermutation(10, 17);
        
        for (int i = 1; i <= 8; i++) {
            System.out.println("f(" + i + ") = " + prp.f(i));
        }
    }
}