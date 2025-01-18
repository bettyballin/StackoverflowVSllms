public class BitwiseConverter {
    static long longValue = System.nanoTime(); // Assign the 64bit value here
    static short shortValue = (short) ((longValue >> 32) & getPartial(longValue)); // This will provide a conversion that chops off leftmost bits and keeps last (16th-63rd bit in this case).
    
    public static int getPartial(long data) {
        return ~((~0L) << 16); // A mask for all the last 16 bits starting from the rightmost one.
    }
    
    public static void main(String[] args) {
    }
}