import java.lang.String;

public class Hashtable {
    private Entry[] table;
    private int size;
    private int threshold;

    public Hashtable(int initialCapacity) {
        table = new Entry[initialCapacity];
        size = 0;
        threshold = (int) (initialCapacity * 0.75); // 75% load factor
    }

    public void put(Object key, Object value) {
        if (size >= threshold) {
            resize();
        }
        // ... (rest of the put method implementation)
    }

    private void resize() {
        int newCapacity = table.length * 2;
        Entry[] newTable = new Entry[newCapacity];
        for (Entry entry : table) {
            if (entry != null) {
                int newIndex = entry.key.hashCode() % newCapacity;
                newTable[newIndex] = entry;
            }
        }
        table = newTable;
        threshold = (int) (newCapacity * 0.75);
    }

    private static class Entry {
        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(10);
        // Test the hashtable here
    }
}