import java.lang.String;

public class LongArithmeticUtils {
    public long addLong(long a, long b) {
        // JVM internally performs the following operations
        // Split the 64-bit values into two 32-bit parts
        int aHigh = (int) (a >>> 32);
        int aLow = (int) a;
        int bHigh = (int) (b >>> 32);
        int bLow = (int) b;

        // Perform the addition in two steps
        int sumLow = aLow + bLow;
        int sumHigh = aHigh + bHigh + (sumLow >>> 31);

        // Combine the results
        return ((long) sumHigh << 32) | (long) sumLow;
    }

    public static void main(String[] args) {
        LongArithmeticUtils utils = new LongArithmeticUtils();
        // Example usage:
        long result = utils.addLong(1000000000L, 2000000000L);
        System.out.println("Result: " + result);
    }
}