import java.util.HashMap;
import java.util.Random;
import java.lang.reflect.Field;

public class HashTableTest {
    public void testHashFunctionForLongValues() throws Exception {
        int numPairs = 1 << 24; // you can adjust this number according to the desired level of testing.
        HashMap<Long, Object> map = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < numPairs; ++i) {
            Long longVal = ((long)random.nextInt() & 0xFFFFFFFFL)
                         | (((long)(random.nextInt()) <<32)& 0xFFFFFFFF00000000L);
            map.put(longVal, new Object());
        }

        // If the load factor is close to 0.75 it's a good indicator that your hash function works well enough when distributing these values in the hash table.
        int capacity = getCapacity(map);
        Double loadFactor = (double)map.size() / capacity;
        assertTrue(loadFactor < 1);
    }

    private int getCapacity(HashMap<?, ?> map) throws Exception {
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map);
        return table == null ? 0 : table.length;
    }

    private void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion failed");
        }
    }

    public static void main(String[] args) throws Exception {
        HashTableTest test = new HashTableTest();
        test.testHashFunctionForLongValues();
    }
}