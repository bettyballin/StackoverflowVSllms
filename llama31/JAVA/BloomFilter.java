import java.lang.String;
import java.util.BitSet;

public class BloomFilter {
    private final BitSet bitSet;
    private final int hashFunctions;
    private final int size;

    public BloomFilter(int size, int hashFunctions) {
        this.size = size;
        this.hashFunctions = hashFunctions;
        this.bitSet = new BitSet(size);
    }

    public void add(String zipCode) {
        for (int i = 0; i < hashFunctions; i++) {
            int index = hash(zipCode, i) % size;
            bitSet.set(index);
        }
    }

    public boolean mightContain(String zipCode) {
        for (int i = 0; i < hashFunctions; i++) {
            int index = hash(zipCode, i) % size;
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String input, int salt) {
        int hash = input.hashCode() + salt;
        return hash;
    }

	public static void main(String[] args) {
	}
}