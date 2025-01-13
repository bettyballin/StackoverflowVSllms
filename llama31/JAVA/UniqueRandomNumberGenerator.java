import java.lang.String;
import java.security.SecureRandom;
import java.util.BitSet;

public class UniqueRandomNumberGenerator {
    private static final int MAX_NUMBER = 9999999;
    private static final int BLOOM_FILTER_SIZE = 10_000_000;
    private static final int NUM_HASH_FUNCTIONS = 3;

    private final SecureRandom random = new SecureRandom();
    private final BitSet bloomFilter = new BitSet(BLOOM_FILTER_SIZE);

    public int generateUniqueNumber() {
        while (true) {
            int number = random.nextInt(MAX_NUMBER + 1);
            if (!bloomFilter.get(number)) {
                // likely unique, insert into database
                // update bloom filter
                bloomFilter.set(number);
                return number;
            }
        }
    }

	public static void main(String[] args) {
	}
}