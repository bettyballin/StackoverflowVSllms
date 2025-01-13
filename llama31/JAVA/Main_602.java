import java.lang.String;
import java.util.Random;

public class Main_602 {
    public static void main(String[] args) {
        long seed = 1234567890L; // Same seed value for both PRNGs
        Random prng1 = new Random(seed);
        Random prng2 = new Random(seed);

        for (int i = 0; i < 10; i++) {
            System.out.println("PRNG1: " + prng1.nextInt(100) + " PRNG2: " + prng2.nextInt(100));
        }
    }
}