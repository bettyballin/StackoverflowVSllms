import java.lang.String;

public class HashCalculator {
    public int hash(int key) {
        int hash = 2166136261;
        hash ^= key;
        hash *= 16777219;
        return hash;
    }

    public static void main(String[] args) {
        HashCalculator calculator = new HashCalculator();
        int key = 12345; // Example key
        int hash = calculator.hash(key);
        System.out.println("Hash for key " + key + ": " + hash);
    }
}