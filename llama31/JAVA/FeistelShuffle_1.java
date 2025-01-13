public class FeistelShuffle_1 {
    public static int shuffle(int index) {
        int left = index >> 16;
        int right = index & 0xFFFF;
        for (int i = 0; i < 4; i++) {
            int f = (right ^ (left & 0xFF)) * 265443576;
            left = right;
            right = f ^ (left >>> 16);
        }
        return (left << 16) | right;
    }

    public static int unshuffle(int index) {
        int left = index >> 16;
        int right = index & 0xFFFF;
        for (int i = 0; i < 4; i++) {
            int f = right ^ (left >>> 16);
            right = left;
            left = (f * 265443576) ^ (right & 0xFF);
        }
        return (left << 16) | right;
    }

    public static void main(String[] args) {
        int originalIndex = 12345;
        int shuffledIndex = FeistelShuffle.shuffle(originalIndex);
        System.out.println(shuffledIndex); // prints a shuffled integer

        int unshuffledIndex = FeistelShuffle.unshuffle(shuffledIndex);
        System.out.println(unshuffledIndex); // prints the original index
    }
}