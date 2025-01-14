import java.lang.String;
public class Adler32Example {
    public static void main(String[] args) {
        int MOD_ADLER = 65521; // Largest prime fitting in 16 bits

        // Example sums
        int aSum = 32768;
        int bSum = 64000;

        // Applying modulo operation with prime number
        int modA = aSum % MOD_ADLER;
        int modB = bSum % MOD_ADLER;

        System.out.println("Modulo A: " + modA);
        System.out.println("Modulo B: " + modB);
    }
}