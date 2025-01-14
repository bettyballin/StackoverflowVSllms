public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.table = (Entry<K, V>[]) new Entry[this.capacity];
    }

    public void put(K key, V value) {
        if (size >= this.capacity * 0.75) { // Load factor threshold
            resize();
        }
        // Insert logic here
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        Entry<K,V>[] oldTable = table;

        capacity *= 2;
        table = (Entry<K,V>[]) new Entry[capacity];
        size = 0; // Reset size during rehash

        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue()); // Reinsert elements
            }
        }
    }

    // Inner class Entry
    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }
        V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
    }
}