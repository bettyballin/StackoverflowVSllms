public class ReversibleShuffle {
    private static final int MOD = 1024; // Adjust modulus as needed, should cover your range
    private static final int[] KEY = {0x13579BDF, 0x2468ACE0}; // Use a secure key

    public static int shuffle(int index) {
        return feistelNetwork(index, true);
    }

    public static int unshuffle(int hash) {
        return feistelNetwork(hash, false);
    }

    private static int feistelNetwork(int value, boolean encrypt) {
        final int ROUNDS = 16;
        int L = value >> 5; // Adjust shift based on your MOD
        int R = value & 31; // Mask to extract lower 5 bits

        for (int i = 0; i < ROUNDS; i++) {
            int F = substitute(encrypt ? R : L, i);
            if (encrypt) {
                int temp = L;
                L = R;
                R = temp ^ F;
            } else {
                int temp = R;
                R = L;
                L = temp ^ F; 
            }
        }

        return ((R << 5) | L); // Adjust shift based on your MOD
    }

    private static int substitute(int input, int round) {
        return (input + key(round)) % 32; // modulo 32 since we're working with 5 bits
    }

    private static int key(int round) {
        return KEY[round % KEY.length];
    }

    public static void main(String[] args) {
        for (int i = 0; i < MOD / 2; i++) { // Loop should cover the range you use
            int shuffled = shuffle(i);
            int unshuffled = unshuffle(shuffled);
            System.out.println("Index: " + i + ", Shuffle: " + shuffled + ", Unshuffle: " + unshuffled);
        }
    }
}