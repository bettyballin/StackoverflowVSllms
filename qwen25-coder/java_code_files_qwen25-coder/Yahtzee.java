import java.lang.String;
import java.util.Arrays;

public class Yahtzee {
    public static boolean hasSmallStraight(int[] dice) {
        // Sort the array first
        Arrays.sort(dice);
        
        // Check for sequences
        for (int i = 0; i <= 1; i++) { // Only need to check starting at index 0 or 1
            if (dice[i] + 1 == dice[i + 1] &&
                dice[i + 1] + 1 == dice[i + 2] &&
                dice[i + 2] + 1 == dice[i + 3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] diceRolls = {3, 4, 6, 5, 2};
        System.out.println("Has small straight: " + hasSmallStraight(diceRolls)); // Should print true
    }
}