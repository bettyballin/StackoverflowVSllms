public class BitChecker {
    public static boolean IsBitTrue(int number, int bitPosition) {
        return ((number & (1 << (bitPosition - 1))) != 0);
    }
    public static void main(String[] args) {
        // Example usage:
        System.out.println(BitChecker.IsBitTrue(10, 2));  // prints: true
    }
}