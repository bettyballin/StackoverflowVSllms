import java.util.HashSet;
import java.util.Set;

public class SmallestNonNegativeIntegerFinder {
    public static long findSmallestNonNegativeInteger(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (num >= 0) { // Only add non-negative numbers to the set
                numSet.add(num);
            }
        }

        long smallestMissing = 0;
        while (true) {
            if (!numSet.contains((int) smallestMissing)) {
                return smallestMissing;
            }
            smallestMissing++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4, 7};
        System.out.println(findSmallestNonNegativeInteger(nums)); // Output: 2
    }
}