import java.lang.String;
public class FeistelShuffle {
    private static final int NUM_ROUNDS = 4; // adjust this value as needed
    private static final int MASK = 0x7FFFFFFF; // 31-bit mask

    public static int shuffle(int index) {
        int x = index;
        for (int i = 0; i < NUM_ROUNDS; i++) {
            x = (x ^ ((x & MASK) >>> 16)) & MASK;
            x = (x ^ ((x & MASK) << 16)) & MASK;
        }
        return x;
    }

    public static int unshuffle(int shuffledIndex) {
        int x = shuffledIndex;
        for (int i = 0; i < NUM_ROUNDS; i++) {
            x = (x ^ ((x & MASK) >>> 16)) & MASK;
            x = (x ^ ((x & MASK) << 16)) & MASK;
        }
        return x;
    }

	public static void main(String[] args) {
	}
}