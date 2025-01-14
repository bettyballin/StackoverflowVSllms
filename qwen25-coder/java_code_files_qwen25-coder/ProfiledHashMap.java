import java.util.LinkedHashMap;
import java.util.Map;

public class ProfiledHashMap<K, V> extends LinkedHashMap<K, V> {
    private int rehashCount = 0;
    private int[] chainLengths;

    public ProfiledHashMap() {
        super();
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        rehashCount++;
        return super.removeEldestEntry(eldest);
    }

    public void resize(int newCapacity) {
        chainLengths = calculateChainLengths();
        // Placeholder for resize operation
    }

    private int[] calculateChainLengths() {
        // Implement a method to calculate the current chain lengths
        return new int[0]; // Placeholder implementation
    }

    public int getRehashCount() {
        return rehashCount;
    }

    public int[] getChainLengths() {
        return chainLengths;
    }

    public static void main(String[] args) {
    }
}