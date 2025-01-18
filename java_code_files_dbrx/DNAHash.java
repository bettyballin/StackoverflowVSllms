public class DNAHash {
    private static final int[] LOOKUP_TABLE = new int[]{'A', 'C', 'G', 'T'};
    private static long hashCode(String input) {
        if (input.length() != 21){
            throw new IllegalArgumentException("Input length must be exactly 21");
        }
        long acc = 0L;
        for (int i = 0, len = input.length(); i < len; ++i) {
            char c = input.charAt(i);
            int index = (c == 'A') ? 0 : (c == 'C') ? 1 : (c == 'G') ? 2 : 3; // find the index in LOOKUP_TABLE
            acc = ((acc >>> 2) ^ LOOKUP_TABLE[index]) & 0xffffffffL;           // Perform shift-right and XOR operation
        }
        return acc;
    }

    public static void main(String[] args) {
    }
}