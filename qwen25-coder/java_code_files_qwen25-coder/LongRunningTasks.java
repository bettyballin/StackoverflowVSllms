import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class LongRunningTasks {

    // Method to simulate long-running task using cryptographic hashing
    public void hashStringRepeatedly(String input, int iterations) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] data = input.getBytes();
            for (int i = 0; i < iterations; i++) {
                data = digest.digest(data);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Method to simulate long-running task using BigInteger operations
    public BigInteger performBigIntegerExponentiation(int exponent) {
        BigInteger base = new BigInteger("1234567890123456789012345678901234567890");
        return base.pow(exponent);
    }

    public static void main(String[] args) {
        LongRunningTasks tasks = new LongRunningTasks();

        // Example of using hashStringRepeatedly
        long startHash = System.currentTimeMillis();
        tasks.hashStringRepeatedly("dummystring", 1000);
        System.out.println("hashStringRepeatedly: " + (System.currentTimeMillis() - startHash));

        // Example of using performBigIntegerExponentiation
        long startBigInt = System.currentTimeMillis();
        tasks.performBigIntegerExponentiation(50);
        System.out.println("performBigIntegerExponentiation: " + (System.currentTimeMillis() - startBigInt));
    }
}