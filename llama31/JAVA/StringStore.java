import java.lang.String;
import java.util.Arrays; // Added import statement for Arrays class

public class StringStore {
    private static final int CHUNK_SIZE = 1000;
    private String[][] chunks;
    private int chunkCount;

    public StringStore(int initialCapacity) {
        chunkCount = (int) Math.ceil((double) initialCapacity / CHUNK_SIZE);
        chunks = new String[chunkCount][];
        for (int i = 0; i < chunkCount; i++) {
            chunks[i] = new String[CHUNK_SIZE];
        }
    }

    public void addString(String str) {
        int chunkIndex = chunkCount - 1;
        int indexInChunk = CHUNK_SIZE - 1;
        if (chunks[chunkIndex][indexInChunk] != null) {
            // Create a new chunk if the last one is full
            chunkCount++;
            chunks = Arrays.copyOf(chunks, chunkCount);
            chunks[chunkIndex] = new String[CHUNK_SIZE];
            indexInChunk = 0;
        }
        chunks[chunkIndex][indexInChunk] = str;
    }

    public String getString(int index) {
        int chunkIndex = index / CHUNK_SIZE;
        int indexInChunk = index % CHUNK_SIZE;
        return chunks[chunkIndex][indexInChunk];
    }

    public static void main(String[] args) {
        // Example usage:
        StringStore store = new StringStore(10);
        store.addString("Hello");
        store.addString("World");
        System.out.println(store.getString(0)); // prints "Hello"
        System.out.println(store.getString(1)); // prints "World"
    }
}