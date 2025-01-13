import java.lang.String;

public class SingleNumberFinder {
    public int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumberFinder singleNumberFinder = new SingleNumberFinder();
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4};
        System.out.println("Single number: " + singleNumberFinder.findSingleNumber(nums));
    }
}