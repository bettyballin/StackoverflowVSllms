public class BitExtraction {
    public static void main(String[] args) {
        long longValue = 0x1234567890ABCDEFL; // Assign your 64-bit value here

        int N = 16; // Number of bits to shift
        long MASK = 0xFFFFL; // Mask to extract 16 bits

        // Extract higher 16-bits -- shift right and keep leftmost bytes if needed.
        long shortValueHi = ((longValue >>> N) & MASK); // for some value of MASK, e.g., 0xFFFF

        // Extract lower 16-bits -- keep rightmost bytes if needed.
        long shortValueLo = ((longValue << N)); // With N as length shift left, usually in reverse of upper part masking

        // Output the results
        System.out.println("Higher 16 bits: " + shortValueHi);
        System.out.println("Lower 16 bits after left shift: " + shortValueLo);
    }
}