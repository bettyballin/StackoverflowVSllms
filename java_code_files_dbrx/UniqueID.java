import java.lang.management.*;
import java.util.Random;

public class UniqueID {
    private static final int TIMESTAMP_BITS = 32;
    private static final long MAX_TIMESTAMP = (1L << TIMESTAMP_BITS) - 1L;
    private static final int RANDOM_BITS = 8;
    private static final int PROCESS_ID_BITS = 16;

    public static void main(String[] args) {
        System.out.println("Unique ID: " + String.format("%x", getUniqueId()));
    }

    public static long getUniqueId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp > MAX_TIMESTAMP)
            throw new RuntimeException("Too much time has passed!");
        Random random = new Random(System.nanoTime());
        int randomValue = random.nextInt(1 << RANDOM_BITS);
        long uniqueId = ((long) randomValue) << PROCESS_ID_BITS;

        long pid = ProcessHandle.current().pid();
        uniqueId |= (pid & ((1L << PROCESS_ID_BITS) - 1));

        return (timestamp << RANDOM_BITS) | uniqueId;
    }
}