import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

public class UniqueSymbolIdentifier {
    private static final XXHash32 xxHashInstance = XXHashFactory.fastestInstance().hash32();
    private static final int SEED = 0; // Use any seed value you prefer

    public long generateIdFromString(final String symbol) {
        byte[] data = symbol.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        int hash = xxHashInstance.hash(data, 0, data.length, SEED);
        return (long) hash;
    }

    public static void main(String[] args) {
    }
}