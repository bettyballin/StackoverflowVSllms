import java.lang.String;
public class MajorityElementFinder {
    public static int findMajorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Phase 1: Find a candidate for majority element
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate; // This is the majority element
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("The majority element is: " + findMajorityElement(array));
    }
}