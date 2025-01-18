import java.util.ArrayList;
import java.util.List;

public class Main_209 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        // Adding items to the list in a specific order
        nums.add(1);
        nums.add(2);
        nums.add(3);

        // Enumerating over the list
        for (int i : nums) {
            System.out.println(i);
        }
    }
}