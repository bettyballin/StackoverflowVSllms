import java.lang.String;
public class UniqueNumberFinder {
    public static int findSingle(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            unique ^= num;
        }
        return unique;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 5, 3, 4};
        System.out.println("Unique number: " + findSingle(nums)); // Output will be 2
    }
}