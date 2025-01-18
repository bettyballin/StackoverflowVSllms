import java.util.BitSet;

public class FlagChecker {

    // Simulate some value
    long values = 0xFFL; // Example value

    // Create BitSet from values
    BitSet bits = BitSet.valueOf(new long[] { values & 0xFFFFFFFFL });

    // Define binary strings for bit positions
    static final String ValueOne = "1";   // Bit position 1 (binary 1)
    static final String ValueTwo = "10";  // Bit position 2 (binary 10)
    static final String ValueThree = "11"; // Bit position 3 (binary 11)

    // Check if specific bits are set
    boolean containsValueOne = bits.get(Integer.parseInt(ValueOne, 2));
    boolean containsValueTwo = bits.get(Integer.parseInt(ValueTwo, 2));
    boolean containsValueThree = bits.get(Integer.parseInt(ValueThree, 2));
    // ... and so on ..

    public static void main(String[] args) {
        FlagChecker checker = new FlagChecker();
        System.out.println("Contains Value One: " + checker.containsValueOne);
        System.out.println("Contains Value Two: " + checker.containsValueTwo);
        System.out.println("Contains Value Three: " + checker.containsValueThree);
    }
}