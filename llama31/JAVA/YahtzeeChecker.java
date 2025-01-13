import java.lang.String;

public class YahtzeeChecker {
    public boolean hasSmallStraight(int[] dice) {
        int[] counts = new int[7]; // 1-6, plus one extra for safety
        for (int die : dice) {
            counts[die]++;
        }
        for (int i = 1; i <= 3; i++) {
            if (counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0 && counts[i + 3] > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        YahtzeeChecker checker = new YahtzeeChecker();
        int[] dice = {1, 2, 3, 4, 5};
        System.out.println(checker.hasSmallStraight(dice)); // prints: true
    }
}