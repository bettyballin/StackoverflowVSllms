import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashFunctionTest {

    public static int yourHashFunction(long input) {
        // A simple hash function, replace with your own implementation
        return (int) (input % 256);
    }

    @Test
    public void testHashDistribution() {
        int numInputs = 100000;
        int[] hashCounts = new int[256]; // assuming 8-bit hash

        for (int i = 0; i < numInputs; i++) {
            long input = (long) (Math.random() * Long.MAX_VALUE);
            int hash = yourHashFunction(input);
            hashCounts[hash]++;
        }

        // Calculate chi-squared statistic
        double chiSquared = 0;
        for (int i = 0; i < 256; i++) {
            double expected = numInputs / 256.0;
            double observed = hashCounts[i];
            chiSquared += ((observed - expected) * (observed - expected)) / expected;
        }

        // Check if chi-squared statistic is within acceptable range
        assertTrue(chiSquared < 256 * 1.1); // adjust this value as needed
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("HashFunctionTest");
    }
}