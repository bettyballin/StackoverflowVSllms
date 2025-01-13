import java.lang.String;

public class HashTable {
    private static final int INITIAL_VALUE = 2166136261;
    private static final int MAGIC_NUMBER = 16777219;
    private static final int BOUNDS = 257; // coprime to table length
    private static final int TABLE_LENGTH = 269; // prime

    public static int hash(String word) {
        int hash = INITIAL_VALUE;
        for (char c : word.toCharArray()) {
            hash *= MAGIC_NUMBER;
            hash ^= c;
            hash %= BOUNDS;
        }
        return hash % TABLE_LENGTH; // ensure the hash is within the table length
    }

    public static void main(String[] args) {
        String word = "example";
        int hash = hash(word);
        System.out.println("Hash value: " + hash);
    }
}