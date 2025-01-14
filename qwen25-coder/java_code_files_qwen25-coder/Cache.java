import java.util.Map;
import java.util.HashMap;

public class Cache {

    Map<Integer, CacheLine> lines; // Mapping address to cache line

    class CacheLine {
        int tag;
        byte[] data;

        CacheLine(int tag, byte[] data) {
            this.tag = tag;
            this.data = data;
        }
    }

    Cache(int size) {
        this.lines = new HashMap<>(size);
    }

    public void storeData(int address, byte[] data) {
        int lineAddress = computeCacheLineAddress(address);
        lines.put(lineAddress, new CacheLine(computeTag(address), data));
    }

    public byte[] loadData(int address) {
        int lineAddress = computeCacheLineAddress(address);
        CacheLine line = lines.get(lineAddress);
        if (line != null && line.tag == computeTag(address)) {
            return line.data;
        }
        return null; // Miss
    }

    private int computeCacheLineAddress(int address) {
        // Simple modulo operation to determine cache line based on address
        return address % lines.size();
    }

    private int computeTag(int address) {
        // Extract the tag from the address for comparison
        return (address / lines.size()) & 0xFFFF; // Example, tag size can vary
    }

    public static void main(String[] args) {
    }
}