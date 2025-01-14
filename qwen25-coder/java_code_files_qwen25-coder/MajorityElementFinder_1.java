import java.lang.String;
public class MajorityElementFinder_1 {
    public static int findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int candidate = 0;
        int count = 0;

        // Phase 1: Find a candidate for majority element
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate; // Since problem guarantees majority exists, no need for verification
    }

    public static void main(String[] args) {
        int[] testArray = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + findMajorityElement(testArray)); // Output should be 2
    }
}