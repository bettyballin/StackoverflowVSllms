import java.lang.String;
public class UniqueIDGenerator {
    private static final int TIMESTAMP_BITS = 40; // 40 bits for timestamp (about 34 years)
    private static final int RANDOM_BITS = 24; // 24 bits for random number

    public static long getUniqueID() {
        long timestamp = System.currentTimeMillis() << RANDOM_BITS;
        long random = (long) (Math.random() * (1L << RANDOM_BITS));
        return timestamp | random;
    }

	public static void main(String[] args) {
	}
}