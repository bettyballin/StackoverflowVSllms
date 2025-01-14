import java.lang.String;
public class StringHasher {
    public int hash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = hash * 31 + c;
        }
        return hash & 0x7FFFFFFF; // Ensure the result is non-negative
    }
    public static void main(String[] args) {
    }
}