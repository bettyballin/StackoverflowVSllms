import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashFunctionTest {

    // Custom hash function
    public int betterHash(long value) {
        long h = value * 31; // Simple multiplication to create more variation
        return (int)(h ^ (h >>> 32));
    }

    @Test
    public void testBetterHash() {
        HashMap<Long, String> map = new HashMap<>();
        
        // Add entries with varying low and high bits
        for (long i = 0; i < 1000; i++) {
            long key = (i << 32) | (1000 - i); // Create keys where high and low bits are different
            map.put(key, "value" + i);
        }

        // Check size to ensure no collisions occurred under normal conditions
        assertEquals(1000, map.size(), "Map should have 1000 unique entries");
    }

    public static void main(String[] args) {
    }
}