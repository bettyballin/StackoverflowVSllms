import java.lang.String;
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                count += (num == candidate) ? 1 : -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 4, 3, 4, 5, 3, 3};
        System.out.println("Majority element is " + majorityElement(nums));
    }
}